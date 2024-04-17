package com.wax.cliniccontrol.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.wax.cliniccontrol.R
import com.wax.cliniccontrol.databinding.ActivityListDoctorsBinding
import com.wax.cliniccontrol.model.address.Address
import com.wax.cliniccontrol.model.doctor.Doctor
import com.wax.cliniccontrol.model.doctor.Specialty
import com.wax.cliniccontrol.ui.recyclerview.adapter.ListDoctorsAdapter


class ListDoctorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListDoctorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupRecyclerView()
        setupToolbar()
        setupListeners()
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = ListDoctorsAdapter(
            this, listOf(
                Doctor(
                    "Fernanda Araujo Lopes",
                    "fernanda@gmail.com",
                    "12312-AM",
                    "92982618754",
                    Specialty.GINECOLOGIA,
                    Address(
                        "Comandante Nathaniel",
                        "Da Paz",
                        "69098-030",
                        "461",
                        "Manaus",
                        "Numero 1",
                        "AM"
                    )
                ),
                Doctor(
                    "Wadrian Araujo de Moura",
                    "wadrian@gmail.com",
                    "11212-AM",
                    "92982618734",
                    Specialty.CARDIOLOGIA,
                    Address(
                        "Capitolio",
                        "Novo aleixo",
                        "69098-412",
                        "39",
                        "Manaus",
                        "nucleo 15",
                        "AM"
                    )
                )
            )
        )
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
        val intent = Intent(this, FormDoctorActivity::class.java)
        startActivity(intent)
    }
}