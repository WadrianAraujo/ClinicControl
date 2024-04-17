package com.wax.cliniccontrol.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.wax.cliniccontrol.R
import com.wax.cliniccontrol.model.doctor.Doctor

class ListDoctorsAdapter(
    private val content: Context,
    private val doctors: List<Doctor>
) : RecyclerView.Adapter<ListDoctorsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(doctor: Doctor) {
            val name = itemView.findViewById<TextView>(R.id.tv_name)
            name.text = doctor.name

            val specialty = itemView.findViewById<TextView>(R.id.tv_specialty)
            specialty.text = doctor.specialty.toString()

            val crm = itemView.findViewById<TextView>(R.id.tv_crm)
            crm.text = "CRM " + doctor.crm

            val email = itemView.findViewById<TextView>(R.id.tv_email)
            email.text = doctor.email

            val phone = itemView.findViewById<TextView>(R.id.tv_phoneNumber)
            phone.text = doctor.phone

            val address = itemView.findViewById<TextView>(R.id.tv_address)
            address.text = doctor.address.toString()

            val btnExpand = itemView.findViewById<ImageView>(R.id.btn_expand)
            btnExpand.setOnClickListener {
                val content = itemView.findViewById<ViewGroup>(R.id.expandingContentLayout)
                if (content.visibility == View.VISIBLE){
                    content.visibility = View.GONE
                }else{
                    content.visibility = View.VISIBLE
                }

            }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(content)
        val view = inflater.inflate(R.layout.expandable_card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return doctors.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doctor = doctors[position]
        holder.bind(doctor)
    }

}
