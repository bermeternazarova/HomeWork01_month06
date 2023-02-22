package com.example.homework01_month06.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework01_month06.databinding.ActivityMainBinding
import com.example.homework01_month06.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var getResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataLauncher()
        launchers()
        actions()
    }

    private fun launchers() {
        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                binding.et.setText(
                    it.data?.getStringExtra(EXTRA_MESSAGE))
            }
        }
    }

    private fun getDataLauncher() {
        binding.et.setText(intent.getStringExtra(EXTRA_MESSAGE))
    }

    private fun actions() {
        binding.btn.setOnClickListener {
            if (binding.et.text.isEmpty()) {
                showToast("Text cannot be empty!!")
            } else {
                sendResult()
            }
        }
    }

    private fun sendResult() {
        val intent = Intent(applicationContext, MainActivity2::class.java)
        intent.putExtra(EXTRA_MESSAGE, binding.et.text.toString())
        getResult.launch(intent)
    }
}