package com.martamazurkozlowska.superapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform