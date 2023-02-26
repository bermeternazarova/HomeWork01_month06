package com.example.homework01_month06.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework01_month06.R
import com.example.homework01_month06.databinding.ActivityMain2Binding
import com.example.homework01_month06.showToast

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        actionsA2()
    }

    private fun initView() {
        binding.etEnter.setText(intent.getStringExtra(KEY))
    }

    private fun actionsA2() {
        binding.btnBack.setOnClickListener {
            if (binding.etEnter.text.isEmpty()) {
                showToast(getString(R.string.text_cantbe_empty))
            } else {
                getResultLauncher()
            }
        }
    }

    private fun getResultLauncher() {
        val intent = Intent(this,MainActivity::class.java)
            .putExtra(KEY, binding.etEnter.text.toString())
        setResult(RESULT_OK, intent)
       finish()
    }
    companion object{
        const val KEY ="key"
    }
}
