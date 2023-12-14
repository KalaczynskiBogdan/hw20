package com.example.myapplication.hw18.todoList

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentListBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ListFragment : Fragment() {
    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var toolbar: Toolbar
    private lateinit var image: ImageView

    private val tabNames = listOf(
        "in progress",
        "done",
        "deleted"
    )

    private var navigation: Navigation? = null
    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding
        get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigation = activity as? Navigation
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showList()
        clickOnImage()
    }

    private fun showList() {
        toolbar = binding.toolbar
        val inflater = LayoutInflater.from(context)
        val customView = inflater.inflate(R.layout.custom_toolbar, toolbar, false)
        toolbar.addView(customView)

        adapter = NumberAdapter(this)
        viewPager = binding.viewPager
        viewPager.adapter = adapter

        tabLayout = binding.tabLayout

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNames[position]

        }.attach()
    }
    private fun clickOnImage() {
        image = binding.toolbar.findViewById(R.id.imageUser)
        image.setOnClickListener {
            navigation?.showUserScreen()
        }
    }
}
