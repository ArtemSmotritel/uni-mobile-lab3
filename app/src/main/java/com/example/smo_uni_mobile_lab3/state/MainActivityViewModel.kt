package com.example.smo_uni_mobile_lab3.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smo_uni_mobile_lab3.db.dao.PostDao
import com.example.smo_uni_mobile_lab3.db.dao.UserDao
import com.example.smo_uni_mobile_lab3.models.IListItem
import com.example.smo_uni_mobile_lab3.models.Post
import com.example.smo_uni_mobile_lab3.models.User
import com.example.smo_uni_mobile_lab3.models.fakePosts
import com.example.smo_uni_mobile_lab3.models.fakeUsers
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
)

class MainActivityViewModel(private val userDao: UserDao, private val postDao: PostDao) : ViewModel() {

    private val _state = MutableStateFlow(MainActivityState())
    val state: StateFlow<MainActivityState> = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.deleteAll()
            userDao.insertAll(*fakeUsers().toTypedArray())

            val users = userDao.getAll()

            postDao.insertAll(*fakePosts(users).toTypedArray())
        }

        viewModelScope.launch(Dispatchers.IO) {
            combine(
                userDao.getAllAsFlow(),
                postDao.getAllAsFlow()
            ) { users, posts ->
                users.plus(posts)
            }.collect { list ->
                _state.update { currentState ->
                    currentState.copy(list = list, loading = false)
                }
            }
        }
    }

    fun deleteItem(item: IListItem) {
        viewModelScope.launch(Dispatchers.IO) {
            if (item::class == User::class) {
                userDao.delete(item as User)
            } else if (item::class == Post::class) {
                postDao.delete(item as Post)
            }
        }
    }
}
