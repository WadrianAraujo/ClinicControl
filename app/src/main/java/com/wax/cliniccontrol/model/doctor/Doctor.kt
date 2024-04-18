package com.wax.cliniccontrol.model.doctor

import com.google.gson.annotations.SerializedName
import com.wax.cliniccontrol.model.address.Address

data class Doctor(
    @SerializedName("nome")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("crm")
    val crm: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("especialidade")
    val specialty: Specialty,
    @SerializedName("address")
    val address: Address
)
