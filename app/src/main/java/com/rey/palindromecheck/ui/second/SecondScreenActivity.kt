package com.rey.palindromecheck.ui.second

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.rey.palindromecheck.databinding.ActivitySecondScreenBinding
import com.rey.palindromecheck.ui.third.ThirdScreenActivity

class SecondScreenActivity : AppCompatActivity() {
    private var _binding: ActivitySecondScreenBinding? = null
    private val binding get() = _binding!!

    private val launcherIntent = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val getFullName = result.data?.getStringExtra(ThirdScreenActivity.EXTRA_NAME)
            binding.tvSelectedUsername.text = getFullName

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        binding.tvName.text = name
        binding.btnChooseAUser.setOnClickListener {
            val intent = Intent(this, ThirdScreenActivity::class.java)
            launcherIntent.launch(intent)
        }

        binding.materialToolbar.setNavigationOnClickListener {
            finish()
        }
    }


    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}