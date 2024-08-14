package com.rey.palindromecheck

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rey.palindromecheck.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {
    private var _binding: ActivitySecondScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        binding.tvName.text = name
        binding.btnChooseAUser.setOnClickListener {
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}