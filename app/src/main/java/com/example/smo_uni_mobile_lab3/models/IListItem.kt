package com.example.smo_uni_mobile_lab3.models

interface IListItem {
    fun id(): String
    fun title(): String
    fun description(): String?
    fun imageUrl(): String?
}
