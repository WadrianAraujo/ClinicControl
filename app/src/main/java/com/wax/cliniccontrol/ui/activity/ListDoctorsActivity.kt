package com.wax.cliniccontrol.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.wax.cliniccontrol.R
import com.wax.cliniccontrol.api.RetrofitInstance
import com.wax.cliniccontrol.dao.DoctorsDao
import com.wax.cliniccontrol.databinding.ActivityListDoctorsBinding
import com.wax.cliniccontrol.model.doctor.Doctor
import com.wax.cliniccontrol.ui.recyclerview.adapter.ListDoctorsAdapter
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit


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
        lifecycleScope.launch(IO){
            val call: Call<List<Doctor>> = RetrofitInstance().doctorService.getAll()
            val response = call.execute()
            response.body()?.let { doctors ->
                Log.i("ListDoctors", "onCreate: $doctors")
            }
        }
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