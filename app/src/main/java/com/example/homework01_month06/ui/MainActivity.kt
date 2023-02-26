package com.example.homework01_month06.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework01_month06.R
import com.example.homework01_month06.databinding.ActivityMainBinding
import com.example.homework01_month06.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val getText = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode== RESULT_OK &&it.data !=null){
        binding.etEnter.setText(it.data?.getStringExtra(KEY))}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actions()
    }

    private fun actions() {
        binding.btnSend.setOnClickListener {
            if (binding.etEnter.text.isEmpty()) {
                showToast(getString(R.string.text_cannotbe_empty))
            } else {
             val  intent =Intent(this,MainActivity2::class.java).apply {
                    putExtra(KEY,binding.etEnter.text.toString())
                }
                getText.launch(intent)
            }
        }
    }
    companion object{
        const val KEY ="key"
    }
}