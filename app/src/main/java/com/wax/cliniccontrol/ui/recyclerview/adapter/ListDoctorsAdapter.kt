package com.wax.cliniccontrol.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wax.cliniccontrol.databinding.ExpandableCardLayoutBinding
import com.wax.cliniccontrol.model.doctor.Doctor

class ListDoctorsAdapter(
    private val content: Context,
    doctors: List<Doctor>
) : RecyclerView.Adapter<ListDoctorsAdapter.ViewHolder>() {

    private val doctors = doctors.toMutableList()

    class ViewHolder(private val binding: ExpandableCardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(doctor: Doctor) {
            binding.tvName.text = doctor.name
            binding.tvSpecialty.text = doctor.specialty.toString()
            binding.tvCrm.text = "CRM ${doctor.crm}"
            binding.tvEmail.text = doctor.email
            binding.tvPhoneNumber.text = doctor.phone
            binding.tvAddress.text = doctor.address.toString()

            binding.btnExpand.setOnClickListener {
                val content = binding.expandingContentLayout
                content.visibility =
                    if (content.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(content)
        val binding = ExpandableCardLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return doctors.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doctor = doctors[position]
        holder.bind(doctor)
    }

    fun updateList(doctors: List<Doctor>) {
        this.doctors.clear()
        this.doctors.addAll(doctors)
        notifyDataSetChanged()
    }

}