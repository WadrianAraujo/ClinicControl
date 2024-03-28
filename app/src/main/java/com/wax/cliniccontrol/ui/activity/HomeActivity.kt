package com.wax.cliniccontrol.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wax.cliniccontrol.R
import com.wax.cliniccontrol.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        val btnDoctor = binding.btnDoctors

        btnDoctor.setOnClickListener {
            goToListDoctors()
        }
    }

    private fun goToListDoctors() {
        val intent = Intent(this,ListDoctorsActivity::class.java)
        startActivity(intent)
    }
}