package com.example.myapplication

import android.util.Log

class Utils {

    fun <T,M> justForTesting(aa:T,bb:M){
        Log.e("justForTesting","$aa And $bb")
    }

    fun <T> isEmpty(string: T){
        if (string != null) {

        }else{
             checkNotNull(string,{

            })
        }
    }
}