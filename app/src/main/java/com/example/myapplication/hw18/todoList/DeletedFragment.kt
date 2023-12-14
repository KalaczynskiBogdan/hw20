package com.example.myapplication.hw18.todoList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class DeletedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_deleted, container, false)

        val tasks: ArrayList<String> = arrayListOf(
            "Go to the gym",
            "Go for a walk with your dog",
            "Tell your crush about your feelings",
            "Take a good mark",
            "Make a homework"
        )
        val recyclerView: RecyclerView = rootView.findViewById(R.id.rvDeleted)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        val adapter = TaskAdapter(tasks)
        recyclerView.adapter = adapter

        return rootView
    }
    companion object {
        private const val NAME_OF_ITEM = "name"
        fun newInstance(name: String) = DeletedFragment().apply {
            arguments = Bundle().apply {
                putString(NAME_OF_ITEM, name)
            }
        }
    }
}