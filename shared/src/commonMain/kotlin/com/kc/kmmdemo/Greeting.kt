package com.kc.kmmdemo

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}