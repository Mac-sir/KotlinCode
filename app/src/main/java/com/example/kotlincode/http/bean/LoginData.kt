package com.example.kotlincode.http.bean

data class LoginData( var id: Int,
                      var username: String,
                      var password: String,
                      var icon: String?,
                      var type: Int,
                      var collectIds: List<Int>?)
