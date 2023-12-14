package com.example.myapplication.hackathon

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.FragmentLoginBinding
import java.util.Locale

class LoginFragment : Fragment() {
    private var loginName = ""
    private var password = ""

    private var navigationListener: NavigationListener? = null
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationListener = activity as? NavigationListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registration()
    }

    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun registration() {
        binding.buttonEnter.setOnClickListener {
            val loginInput = binding.etLogin.text.toString()
            val passwordInput = binding.etPassword.text.toString()
            val secondPasswordInput = binding.etSecondPassword.text.toString()

            if (loginInput == loginInput.lowercase(Locale.getDefault())) {
                if (passwordInput.length > 6) {
                    if (passwordInput == secondPasswordInput) {
                        showToast("You have been registered")
                        navigationListener?.showFirstScreen()
                        password = passwordInput
                        loginName = loginInput
                    } else {
                        showToast("Passwords are different")
                    }
                } else {
                    showToast("Your password too small")
                }

            } else {
                showToast("Your login must be in small letters")
            }
        }
    }
}