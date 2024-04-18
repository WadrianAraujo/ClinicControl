package com.wax.cliniccontrol.api

import com.wax.cliniccontrol.api.service.DoctorService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.100.5:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val doctorService = retrofit.create(DoctorService::class.java)

}