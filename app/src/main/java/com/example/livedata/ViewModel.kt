package com.example.livedata

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class ViewModel  :ViewModel() {

    var textData = MutableLiveData<String>()
    var editText = MutableLiveData<String>()
    var imageUrl = MutableLiveData<String>()
    var error2 = MutableLiveData<String>()
    var emailText = MutableLiveData<String>()

    fun onClick(view:View) {
        textData.value = "Checked !!!"
    }
    fun isEmailValid(email:String):Boolean{
        val expression = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        val pattern:Pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE)
        val matcher:Matcher = pattern.matcher(email)
        return matcher.matches()
    }
}