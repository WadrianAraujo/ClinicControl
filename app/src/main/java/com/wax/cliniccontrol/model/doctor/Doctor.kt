package com.wax.cliniccontrol.model.doctor

import com.wax.cliniccontrol.model.address.Address

data class Doctor(
    val name: String,
    val email: String,
    val crm: String,
    val phone: String,
    val specialty: Specialty,
    val address: Address
)
