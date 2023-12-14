package com.example.myapplication.hackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity(), NavigationListener {
    private var _binding: ActivityMain2Binding? = null
    private val binding: ActivityMain2Binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        showLoginScreen()
    }

    override fun showLoginScreen() {
        val fragment = LoginFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.flContainer, fragment)
        transaction.commit()
    }

    override fun showFirstScreen() {
        val fragment = FirstFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.flContainer, fragment)
        transaction.commit()
    }

    override fun showSecondScreen() {
        val fragment = DetailsOfEmployeesFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.flContainer, fragment)
        transaction.commit()
    }
}
