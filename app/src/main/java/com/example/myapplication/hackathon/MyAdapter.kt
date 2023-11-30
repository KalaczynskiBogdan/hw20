package com.example.myapplication.hackathon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MyAdapter(private val onRemoveClickListener: (Employee) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private val data: ArrayList<Employee> = arrayListOf()
    fun removeItem(employee: Employee) {
        data.remove(employee)
        notifyDataSetChanged()
    }

    fun setDataAndNotify(employeeList: ArrayList<Employee>) {
        data.addAll(employeeList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_employee, parent, false)
        return MyAdapter.MyViewHolder(view, onRemoveClickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }


    class MyViewHolder(itemView: View, private val onRemoveClickListener: (Employee) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val employeeName: TextView = itemView.findViewById(R.id.tvEmployeeName)
        private val employeePosition: TextView = itemView.findViewById(R.id.tvEmployeePosition)
        private val employeeTrustLevel: TextView = itemView.findViewById(R.id.tvEmployeeTrustLevel)
        private val employeePhoto: ImageView = itemView.findViewById(R.id.tvEmployeePhoto)
        private val imageViewDelete: ImageView = itemView.findViewById(R.id.ivDelete)
        fun bind(employee: Employee) {
            employeeName.text = employee.name
            employeePosition.text = employee.position
            employeeTrustLevel.text = employee.trustLevel
            employeePhoto.setImageResource(employee.photo)
            imageViewDelete.setOnClickListener {
                onRemoveClickListener(employee)
            }
        }

    }


}