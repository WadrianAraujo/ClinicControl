package com.wax.cliniccontrol.model.address

data class Address(
    val street: String,
    val neighborhood: String,
    val cep: String,
    val number: String,
    val city: String,
    val complement: String,
    val uf: String
) {
    override fun toString(): String {
        return "$street $number, $neighborhood - $city/$uf\n$cep"
    }
}