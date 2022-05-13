package com.example.mobilimtahansistemi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobilimtahansistemi.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.recyclerView
    }
}