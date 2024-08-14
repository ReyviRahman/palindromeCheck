package com.rey.palindromecheck.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.rey.palindromecheck.R
import com.rey.palindromecheck.databinding.ActivityMainBinding
import com.rey.palindromecheck.ui.second.SecondScreenActivity

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            if (binding.etName.text.toString().isEmpty()) {
                Toast.makeText(this, "Insert Your Name Please", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondScreenActivity::class.java)
                intent.putExtra(SecondScreenActivity.EXTRA_NAME, binding.etName.text.toString())
                startActivity(intent)

            }
        }
        binding.btnCheck.setOnClickListener {
            val word = binding.etPalindrome.text.toString()
            if (isPalindrome(word)) {
                MaterialAlertDialogBuilder(this)
                    .setTitle(resources.getString(R.string.isPalindrome))
                    .setPositiveButton(resources.getString(R.string.ok)) { dialog, which ->

                    }
                    .show()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle(resources.getString(R.string.notPalindrome))
                    .setPositiveButton(resources.getString(R.string.ok)) { dialog, which ->

                    }
                    .show()
            }

        }
    }

    private fun isPalindrome(text: String): Boolean {
        val cleanText = text.replace("\\s".toRegex(), "").lowercase()
        return cleanText == cleanText.reversed()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}