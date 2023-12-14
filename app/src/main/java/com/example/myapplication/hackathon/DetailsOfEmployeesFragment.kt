package com.example.myapplication.hackathon

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentDetailsOfEmployeesBinding

class DetailsOfEmployeesFragment : Fragment() {
    private var adapter: MyAdapter? = null
    var navigationListener: NavigationListener? = null

    private var _binding: FragmentDetailsOfEmployeesBinding? = null
    private val binding: FragmentDetailsOfEmployeesBinding
        get() = _binding!!
    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationListener = activity as? NavigationListener
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsOfEmployeesBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}