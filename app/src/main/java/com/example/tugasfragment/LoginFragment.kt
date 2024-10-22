package com.example.tugasfragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tugasfragment.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private var registeredEmail: String? = null
    private var registeredPassword: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        val sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        registeredEmail = sharedPreferences.getString("email", null)
        registeredPassword = sharedPreferences.getString("password", null)

        binding.btnLogin.setOnClickListener {
            val inputEmail = binding.editEmailLogin.text.toString()
            val inputPassword = binding.editPasswordLogin.text.toString()

            if (inputEmail == registeredEmail && inputPassword == registeredPassword) {
                Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()

                val intent = Intent(requireActivity(), SecondActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            } else {
                Toast.makeText(requireContext(), "Invalid", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
