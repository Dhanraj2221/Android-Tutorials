package com.example.myapplication

sealed class SealCheck{
    data class Success(val d:String):SealCheck()
    object Loading:SealCheck()
}
