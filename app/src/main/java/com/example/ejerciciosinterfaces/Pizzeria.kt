package com.example.ejerciciosinterfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejerciciosinterfaces.databinding.ActivityPizzeriaBinding
import com.google.android.material.snackbar.Snackbar

class Pizzeria : AppCompatActivity() {
    private lateinit var binding: ActivityPizzeriaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPizzeriaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnSalir.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"btnSalir",Toast.LENGTH_SHORT).show()
        }


    }
}