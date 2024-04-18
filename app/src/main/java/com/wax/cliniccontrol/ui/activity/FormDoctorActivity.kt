package com.wax.cliniccontrol.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.wax.cliniccontrol.R
import com.wax.cliniccontrol.dao.DoctorsDao
import com.wax.cliniccontrol.databinding.ActivityFormDoctorBinding
import com.wax.cliniccontrol.model.address.Address
import com.wax.cliniccontrol.model.doctor.Doctor
import com.wax.cliniccontrol.model.doctor.Specialty

class FormDoctorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupListeners()
        setupExposedDropdown()
    }

    private fun setupListeners() {
        val btnBack = binding.toolbar.ivBack
        btnBack.setOnClickListener {
            finish()
        }

        val btnAddNewDoctor = binding.btnComplete
        btnAddNewDoctor.setOnClickListener {
            val name = binding.textEditName.text.toString()

            val crm = binding.textEditCrm.text.toString()
            val email = binding.textEditEmail.text.toString()
            val phone = binding.textEditPhoneNumber.text.toString()
            val street = binding.textEditPublicPlace.text.toString()
            val number = binding.textEditNumber.text.toString()
            val complement = binding.textEditComplement.text.toString()
            val city = binding.textEditCity.text.toString()
            val uf = binding.autoCompleteTextViewUf.text.toString()
            val cep = binding.textEditCep.text.toString()

            val specialtyText = binding.autoCompleteTextViewSpecialty.text.toString()

            val specialty: Specialty = try {
                Specialty.valueOf(specialtyText.uppercase())
            } catch (e: IllegalArgumentException) {
                Specialty.DERMATOLOGIA
                // Todo: Treat cases in which specialty falls within the exception
            }

            val newDoctor = Doctor(
                name,
                email,
                crm,
                phone,
                specialty,
                Address(
                    street,
                    complement,
                    cep,
                    number,
                    city,
                    complement,
                    uf
                )
            )

            Log.i("FormDoctor","onCreate: ${newDoctor.toString()}")
            DoctorsDao().add(newDoctor)
            finish()
        }
    }

    private fun setupExposedDropdown() {
        val specialties = resources.getStringArray(R.array.specialty)
        val arrayAdapterSpecialties = ArrayAdapter(this, R.layout.dropdown_item, specialties)
        binding.autoCompleteTextViewSpecialty.setAdapter(arrayAdapterSpecialties)

        val uf = resources.getStringArray(R.array.uf)
        val arrayAdapterUF = ArrayAdapter(this, R.layout.dropdown_item, uf)
        binding.autoCompleteTextViewUf.setAdapter(arrayAdapterUF)

    }

    private fun setupToolbar() {
        val title = binding.toolbar.tvTitle
        val text = resources.getString(R.string.toolbar_title_formDoctorsCreate)
        title.text = text
    }
}