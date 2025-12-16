package com.example.mykmpapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform