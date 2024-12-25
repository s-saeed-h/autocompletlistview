package com.example.autocompletlistview

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.autocompletlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val content = arrayOf("apple", "samsong", "google", "htc", "honor")
        val Adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            content
        )
        binding.autocomplete.setAdapter(Adapter)
        binding.autocomplete.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        binding.button.setOnClickListener() {
            val text = binding.autocomplete.text.toString().trim()
            val array = text.split(",")
            for (item in array)
                Log.i("Test_Text", item)
        }

    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}