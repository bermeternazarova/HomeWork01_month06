package com.example.homework01_month06.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework01_month06.databinding.ActivityMain2Binding
import com.example.homework01_month06.showToast

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var getResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        launchers()
        actionsA2()
    }

    private fun launchers() {
        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                binding.etA2.setText(it.data?.getStringExtra(EXTRA_MESSAGE))
            }
        }
    }

    private fun getData() {
        binding.etA2.setText(intent.getStringExtra(EXTRA_MESSAGE))
    }

    private fun actionsA2() {
        binding.btnA2.setOnClickListener {
            if (binding.etA2.text.isEmpty()) showToast("Text cannot be empty!!")
            else getResultLauncher()
        }
    }

    private fun getResultLauncher() {
        val intent = Intent()
        intent.putExtra(EXTRA_MESSAGE, binding.etA2.text.toString())
        getResult.launch(intent)
    }
}
