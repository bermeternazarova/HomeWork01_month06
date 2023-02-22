package com.example.homework01_month06

import android.content.Context
import android.widget.Toast

fun Context.showToast(text:String){
    Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT).show()
}