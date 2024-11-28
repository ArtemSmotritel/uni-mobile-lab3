package com.example.smo_uni_mobile_lab3.models

data class User(
    var id: Long,
    var firstName: String,
    var lastName: String,
    var email: String,
    var phone: String,
) : IListItem {
    override fun title(): String {
        return "$firstName $lastName"
    }

    override fun description(): String {
        return "Email: $email; Phone: $phone"
    }

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
