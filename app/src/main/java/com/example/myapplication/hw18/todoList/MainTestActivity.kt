package com.example.myapplication.hw18.todoList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainTestBinding

class MainTestActivity : AppCompatActivity(), Navigation {
    private var _binding: ActivityMainTestBinding? = null
    private val binding: ActivityMainTestBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "TODO list"
        showListScreen()
    }

    override fun showListScreen() {
        val fragment = ListFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    override fun showUserScreen() {

        val fragment = UserFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}