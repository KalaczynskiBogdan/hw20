package com.example.myapplication.hackathon

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var adapter: MyAdapter? = null
    var navigationListener: NavigationListener? = null

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding
        get() = _binding!!

    private var employeesList: ArrayList<Employee> = arrayListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationListener = activity as? NavigationListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       setListOfEmployees()
    }

    private fun setListOfEmployees(){

        employeesList.add(Employee("Bohdan", "Manager", "high", R.mipmap.ic_launcher))
        employeesList.add(Employee("Oleg", "Cleaner", "low", R.mipmap.ic_launcher))
        employeesList.add(Employee("Vadym", "Cooker", "low", R.mipmap.ic_launcher))
        employeesList.add(Employee("Oksana", "Cooker", "medium", R.mipmap.ic_launcher))
        employeesList.add(Employee("Olena", "Administrator", "high", R.mipmap.ic_launcher))
        employeesList.add(Employee("Arnold", "Security", "medium", R.mipmap.ic_launcher))

        adapter = MyAdapter {
            adapter?.removeItem(it)
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter?.setDataAndNotify(employeesList)
    }

}