package com.wax.cliniccontrol.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wax.cliniccontrol.R
import com.wax.cliniccontrol.databinding.ActivityListDoctorsBinding


class ListDoctorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListDoctorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupListeners()
    }

    private fun setupToolbar() {
        val title = binding.toolbar.tvTitle
        val text = resources.getString(R.string.toolbar_title_listDoctors)
        title.text = text
    }

    private fun setupListeners() {
        val fab = binding.fabAddNewDoctor

        fab.setOnClickListener {
            goToFormDoctor()
        }
    }

    private fun goToFormDoctor() {
        val intent = Intent(this,FormDoctorActivity::class.java)
        startActivity(intent)
    }
}