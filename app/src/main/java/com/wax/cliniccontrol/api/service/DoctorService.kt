package com.wax.cliniccontrol.api.service

import com.wax.cliniccontrol.model.doctor.Doctor
import retrofit2.Call
import retrofit2.http.GET

interface DoctorService {

    @GET("doctor")
    fun getAll(): Call<List<Doctor>>
}