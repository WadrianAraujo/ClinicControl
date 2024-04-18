package com.wax.cliniccontrol.model.address

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Address(
    @SerializedName("logradouro")
    val street: String,
    @SerializedName("bairro")
    val neighborhood: String,
    @SerializedName("cep")
    val cep: String,
    @SerializedName("numero")
    val number: String,
    @SerializedName("cidade")
    val city: String,
    @SerializedName("complemento")
    val complement: String,
    @SerializedName("uf")
    val uf: String
) {
    override fun toString(): String {
        return "$street $number, $neighborhood - $city/$uf\n$cep"
    }
}