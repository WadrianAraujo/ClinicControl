package com.wax.cliniccontrol.ui.activity

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


    }
}