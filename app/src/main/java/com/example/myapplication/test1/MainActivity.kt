package com.example.myapplication.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var adapter: MyAdapter1? = null

    private var personList: ArrayList<Person> = arrayListOf()

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personList.add(Person("ALex", "12345", R.mipmap.ic_launcher))
        personList.add(Person("ALex1", "12345", R.mipmap.ic_launcher))
        personList.add(Person("ALex2", "12345", R.mipmap.ic_launcher))
        personList.add(Person("ALex3", "12345", R.mipmap.ic_launcher))
        personList.add(Person("ALex4", "12345", R.mipmap.ic_launcher))
        personList.add(Person("ALex5", "12345", R.mipmap.ic_launcher))
        personList.add(Person("ALex6", "12345", R.mipmap.ic_launcher))
        personList.add(Person("ALex7", "12345", R.mipmap.ic_launcher))
        personList.add(Person("ALex8", "12345", R.mipmap.ic_launcher))
        personList.add(Person("ALex9", "12345", R.mipmap.ic_launcher))

        adapter = MyAdapter1 {
            adapter?.removeItem(it)
        }
        binding.rvFirst.adapter = adapter
        binding.rvFirst.layoutManager = LinearLayoutManager(this)
        adapter?.setDataAndNotify(personList)
    }
}