package com.example.homework01_month06.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework01_month06.databinding.ActivityMainBinding
import com.example.homework01_month06.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val getText = registerForActivityResult(TextContract()) {
        binding.et.setText(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actions()
    }

    private fun actions() {
        binding.btn.setOnClickListener {
            if (binding.et.text.isEmpty()) {
                showToast("Text cannot be empty!!")
            } else {
                binding.btn.setOnClickListener {
                    getText.launch(binding.et.text)
                }
            }
        }
    }
}