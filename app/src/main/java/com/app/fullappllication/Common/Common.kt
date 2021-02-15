package com.app.fullappllication.Common

import com.app.fullappllication.Retrofit.RetrofitClient
import com.app.fullappllication.Retrofit.RetrofitServices

object Common {
    private var BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}