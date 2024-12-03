package com.example.smo_uni_mobile_lab3.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smo_uni_mobile_lab3.api.JSONPlaceholderAPIRetrofitClient
import com.example.smo_uni_mobile_lab3.api.mapper.PostMapper
import com.example.smo_uni_mobile_lab3.api.mapper.UserMapper
import com.example.smo_uni_mobile_lab3.api.repositories.JSONPlaceholderAPIRepository
import com.example.smo_uni_mobile_lab3.db.dao.PostDao
import com.example.smo_uni_mobile_lab3.db.dao.UserDao
import com.example.smo_uni_mobile_lab3.models.IListItem
import com.example.smo_uni_mobile_lab3.models.Post
import com.example.smo_uni_mobile_lab3.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class MainActivityState(
    val list: List<IListItem> = emptyList(),
    var loading: Boolean = true,
    var currentUser: User? = null,
)

class MainActivityViewModel(private val userDao: UserDao, private val postDao: PostDao) :
    ViewModel() {

    private val repository =
        JSONPlaceholderAPIRepository(JSONPlaceholderAPIRetrofitClient.apiService)

    private val _state = MutableStateFlow(MainActivityState())
    val state: StateFlow<MainActivityState> = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            combine(
                userDao.getAllAsFlow(), postDao.getAllAsFlow()
            ) { users, posts ->
                users.plus(posts)
            }.collect { list ->
                _state.update { currentState ->
                    currentState.copy(list = list, loading = false, currentUser = currentState.currentUser)
                }
            }
        }
    }

    fun reset() {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.deleteAll()

            val apiUsers = repository.fetchUsers()
            val mappedUsers = apiUsers?.map { UserMapper.map(it) }.orEmpty()
            userDao.insertAll(*mappedUsers.toTypedArray())

            val users = userDao.getAll()

            val apiPosts = repository.fetchPosts()
            val photos = repository.fetchAlbumImages(2)
            val mappedPosts = apiPosts?.mapNotNull { PostMapper.map(it, users, photos) }
            if (mappedPosts != null) {
                postDao.insertAll(*mappedPosts.toTypedArray())
            }
        }
    }

    fun deleteItem(item: IListItem) {
        viewModelScope.launch(Dispatchers.IO) {
            when (item) {
                is User -> userDao.delete(item)
                is Post -> postDao.delete(item)
            }
        }
    }

    fun addItem(item: IListItem) {
        viewModelScope.launch(Dispatchers.IO) {
            when (item) {
                is User -> userDao.insertAll(item)
                is Post -> postDao.insertAll(item)
            }
        }
    }

    fun loginAsUser(user: User?) {
        _state.update { currentState ->
            currentState.copy(
                list = currentState.list, loading = currentState.loading, currentUser = user
            )
        }
    }

    fun logout() {
        loginAsUser(null)
    }
}
