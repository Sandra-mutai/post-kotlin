package com.example.myposts

import android.provider.ContactsContract
import retrofit2.http.Body

data class Comments<T>(var name:String, var email: String, var body: String)
