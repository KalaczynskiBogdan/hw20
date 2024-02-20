package com.example.myapplication.hw18.todoList

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.myapplication.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    companion object{
        const val KEY_URI = "KEY_URI"
    }

    private var isInputEnabled = true

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { galleryUri ->
            binding.imageUserTitle.setImageURI(galleryUri)
        }

    private lateinit var image: ImageView
    private lateinit var textName: EditText
    private lateinit var button: Button
    private lateinit var buttonBack: Button
    private var navigation: Navigation? = null

    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigation = activity as? Navigation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findView()
        initClickListeners()
        buttonBack.setOnClickListener {
            navigation?.showListScreen()
        }

    }

    private fun findView() {
        image = binding.imageUserTitle
        textName = binding.etName
        button = binding.buttonSave
        buttonBack = binding.buttonBack
    }

    private fun initClickListeners() {
        image.setOnClickListener {
            galleryLauncher.launch("image/*")
        }
        button.setOnClickListener {
            textName.apply {
                isClickable = isInputEnabled
                isEnabled = isInputEnabled
            }
            image.apply {
                isFocusable = isInputEnabled
                isClickable = isInputEnabled
                isEnabled = isInputEnabled
            }
            button.text = if (isInputEnabled) {
                "save"
            } else {
                "change"
            }
            isInputEnabled = !isInputEnabled
        }
    }
}