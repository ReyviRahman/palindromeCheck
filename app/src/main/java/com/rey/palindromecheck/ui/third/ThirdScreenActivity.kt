package com.rey.palindromecheck.ui.third

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rey.palindromecheck.databinding.ActivityThirdScreenBinding
import com.rey.palindromecheck.ui.LoadingStateAdapter
import com.rey.palindromecheck.ui.ViewModelFactory

class ThirdScreenActivity : AppCompatActivity() {
    private var _binding: ActivityThirdScreenBinding? = null
    private val binding get() = _binding!!

    private val thirdViewModel: ThirdViewModel by viewModels {
        ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        getData()
        binding.materialToolbar.setNavigationOnClickListener {
            finish()
        }

    }

    private fun getData() {
        val adapter = UserAdapter { userName ->
            val returnIntent = Intent()
            returnIntent.putExtra(EXTRA_NAME, userName)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
        binding.rvUsers.adapter = adapter.withLoadStateFooter(
            footer = LoadingStateAdapter {
                adapter.retry()
            }
        )
        thirdViewModel.quote.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}