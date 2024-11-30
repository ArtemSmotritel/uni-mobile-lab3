package com.example.smo_uni_mobile_lab3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "first_name") var firstName: String,
    @ColumnInfo(name = "last_name") var lastName: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "phone") var phone: String,
) : IListItem {
    @Ignore
    override fun id(): String {
        return id.toString()
    }

    @Ignore
    override fun title(): String {
        return "$firstName $lastName"
    }

    @Ignore
    override fun description(): String {
        return "Email: $email; Phone: $phone"
    }

    @Ignore
    override fun imageUrl(): String? {
        return null
    }
}

class UserBuilder {
    private var id: Long = 0
    private var firstName: String = ""
    private var lastName: String = ""
    private var email: String = ""
    private var phone: String = ""

    fun id(id: Long) = apply { this.id = id }
    fun firstName(firstName: String) = apply { this.firstName = firstName }
    fun lastName(lastName: String) = apply { this.lastName = lastName }
    fun email(email: String) = apply { this.email = email }
    fun phone(phone: String) = apply { this.phone = phone }

    fun build(): User {
        return User(
            id = id,
            firstName = firstName,
            lastName = lastName,
            email = email,
            phone = phone
        )
    }
}
