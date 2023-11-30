package com.example.myapplication.test2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    private var binding: FragmentBlankBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(inflater, container, false)

        val text1: String? = this.arguments?.getString("one")

        binding!!.tvFragmentText.text = text1


        return binding!!.root
    }
}