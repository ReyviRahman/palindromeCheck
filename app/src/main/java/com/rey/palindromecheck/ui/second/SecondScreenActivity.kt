package com.rey.palindromecheck.ui.second

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rey.palindromecheck.databinding.ActivitySecondScreenBinding
import com.rey.palindromecheck.ui.third.ThirdScreenActivity

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
            startActivity(Intent(this, ThirdScreenActivity::class.java))
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}