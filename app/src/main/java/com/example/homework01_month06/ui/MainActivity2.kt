package com.example.homework01_month06.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework01_month06.databinding.ActivityMain2Binding
import com.example.homework01_month06.showToast

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        actionsA2()
    }

    private fun actionsA2() {
        binding.btnA2.setOnClickListener {
            if (binding.etA2.text.isEmpty()) showToast("Text cannot be empty!!")
            else getResultLauncher()
        }
    }

    private fun getResultLauncher() {
        val intent = Intent()
            .putExtra("key", binding.etA2.text as CharSequence)
        setResult(RESULT_OK, intent)
        finish()
    }
}
