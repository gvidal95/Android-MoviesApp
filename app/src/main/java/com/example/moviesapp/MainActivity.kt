package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.moviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MainActivity", "onCreate")

//        var name = binding.nameText.text
        binding.recycler.adapter = MoviesAdapter(
            listOf(
                Movie( "Title 1", "https://loremflickr.com/320/240?lock=1"),
                Movie( "Title 2", "https://loremflickr.com/320/240?lock=2"),
                Movie( "Title 3", "https://loremflickr.com/320/240?lock=3"),
                Movie( "Title 4", "https://loremflickr.com/320/240?lock=4"),
                Movie( "Title 5", "https://loremflickr.com/320/240?lock=5"),
                Movie( "Title 6", "https://loremflickr.com/320/240?lock=6 "),
            )
        ) {
            // When a lambda is the last param, allow to move it out of parentheses
            Toast.makeText(this@MainActivity, it.title, Toast.LENGTH_SHORT).show()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main Activity", "onDestroy")
    }
}