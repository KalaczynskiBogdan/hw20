package com.example.myapplication.test1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MyAdapter1(private val onRemoveClickListener: (Person) -> Unit) :
    RecyclerView.Adapter<MyAdapter1.MyViewHolder>() {

    private val data: ArrayList<Person> = arrayListOf()
    fun removeItem(person: Person) {
        data.remove(person)
        notifyDataSetChanged()
    }

    fun setDataAndNotify(personList: ArrayList<Person>) {
        data.addAll(personList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return MyViewHolder(view, onRemoveClickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(itemView: View, private val onRemoveClickListener: (Person) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val personName: TextView = itemView.findViewById(R.id.tvPersonName)
        private val personAge: TextView = itemView.findViewById(R.id.tvPersonAge)
        private val personPhoto: ImageView = itemView.findViewById(R.id.tvPersonPhoto)
        private val imageViewDelete: ImageView = itemView.findViewById(R.id.ivDelete)

        fun bind(person: Person) {
            personName.text = person.name
            personAge.text = person.number
            personPhoto.setImageResource(person.photo)
            imageViewDelete.setOnClickListener {
                onRemoveClickListener(person)
            }
        }
    }
}