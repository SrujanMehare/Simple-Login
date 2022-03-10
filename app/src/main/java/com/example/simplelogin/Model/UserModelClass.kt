package com.example.simplelogin.Model

data class Users(
    val users: ArrayList<UserModelClass>
)

data class UserModelClass(
    val id: String,
    val name: String,
    val email: String,
    val age: Int)

