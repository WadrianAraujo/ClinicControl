package com.wax.cliniccontrol.dao

import com.wax.cliniccontrol.model.doctor.Doctor

class DoctorsDao {

    fun add(doctor: Doctor) {
        doctors.add(doctor)
    }

    fun getAll(): List<Doctor> {
        return doctors.toList()
    }

    companion object {
        private val doctors = mutableListOf<Doctor>()
    }
}