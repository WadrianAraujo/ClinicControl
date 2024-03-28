package com.wax.cliniccontrol.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.wax.cliniccontrol.R
import com.wax.cliniccontrol.databinding.ActivityFormDoctorBinding

class FormDoctorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupExposedDropdown()
    }

    private fun setupExposedDropdown() {
        val specialties = resources.getStringArray(R.array.specialty)
        val arrayAdapterSpecialties = ArrayAdapter(this,R.layout.dropdown_item,specialties)
        binding.autoCompleteTextViewSpecialty.setAdapter(arrayAdapterSpecialties)

        val uf = resources.getStringArray(R.array.uf)
        val arrayAdapterUF = ArrayAdapter(this,R.layout.dropdown_item,uf)
        binding.autoCompleteTextViewUf.setAdapter(arrayAdapterUF)

    }

    private fun setupToolbar() {
        val title = binding.toolbar.tvTitle
        val text = resources.getString(R.string.toolbar_title_formDoctorsCreate)
        title.text = text
    }
}