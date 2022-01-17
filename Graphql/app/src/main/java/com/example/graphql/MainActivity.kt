package com.example.graphql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graphql.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvReviewDescription.text=getString(R.string.text)
        Utils.makeTextViewResizable(binding.tvReviewDescription,3,resources.getString(R.string.decs),true)

    }
}