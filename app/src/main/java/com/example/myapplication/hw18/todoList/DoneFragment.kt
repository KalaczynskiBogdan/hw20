package com.example.myapplication.hw18.todoList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
class DoneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_done, container, false)

        val tasks: ArrayList<String> = arrayListOf(
            "Eat a breakfast",
            "Drink a cup of tea",
            "Brush your teeth",
            "Take a bag with you",
            "Say goodbye to your mama"
        )
        val recyclerView: RecyclerView = rootView.findViewById(R.id.rvDone)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        val adapter = TaskAdapter(tasks)
        recyclerView.adapter = adapter
        return rootView
    }
    companion object {
        private const val NAME_OF_ITEM = "name"
        fun newInstance(name: String) = DoneFragment().apply {
            arguments = Bundle().apply {
                putString(NAME_OF_ITEM, name)
            }
        }
    }
}