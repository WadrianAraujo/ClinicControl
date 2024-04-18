package com.wax.cliniccontrol.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wax.cliniccontrol.R
import com.wax.cliniccontrol.dao.DoctorsDao
import com.wax.cliniccontrol.databinding.ActivityListDoctorsBinding
import com.wax.cliniccontrol.ui.recyclerview.adapter.ListDoctorsAdapter


class ListDoctorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListDoctorsBinding

    private val dao = DoctorsDao()
    private val adapter = ListDoctorsAdapter(this, dao.getAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDoctorsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupToolbar()
        setupListeners()
        setupRecyclerView()
    }

    override fun onResume() {
        adapter.updateList(dao.getAll())
        super.onResume()
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
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

        val btnBack = binding.toolbar.ivBack
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun goToFormDoctor() {
        val intent = Intent(this, FormDoctorActivity::class.java)
        startActivity(intent)
    }
}