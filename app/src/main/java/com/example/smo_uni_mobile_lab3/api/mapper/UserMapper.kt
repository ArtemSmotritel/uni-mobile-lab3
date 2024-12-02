package com.example.smo_uni_mobile_lab3.api.mapper

import com.example.smo_uni_mobile_lab3.api.dto.UserDTO
import com.example.smo_uni_mobile_lab3.models.User
import com.example.smo_uni_mobile_lab3.models.UserBuilder

class UserMapper {
    companion object {
        fun map(user: UserDTO): User {
            return UserBuilder()
                .email(user.email)
                .firstName(user.name.split(' ').first())
                .lastName(user.name.split(' ').last())
                .phone(user.phone)
                .apiId(user.id)
                .build()
        }
    }
}
