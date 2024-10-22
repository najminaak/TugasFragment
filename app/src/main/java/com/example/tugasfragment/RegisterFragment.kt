package com.example.tugasfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tugasfragment.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        binding.btnRegist.setOnClickListener {

            val name = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            val nim = binding.editNim.text.toString()
            val password = binding.editPassword.text.toString()

            if (name.isNotBlank() && email.isNotBlank() && nim.isNotBlank() && password.isNotBlank()) {

                val sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", AppCompatActivity.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("name", name)
                editor.putString("email", email)
                editor.putString("nim", nim)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(requireContext(), "Register Successful", Toast.LENGTH_SHORT).show()

                val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
                viewPager?.currentItem = 0
            } else {
                Toast.makeText(requireContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
