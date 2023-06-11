package com.example.listasg2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listasg2.R
import com.example.listasg2.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {

    lateinit var layout:ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var user=intent.getStringExtra("name")

        layout= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(layout.root)

        layout.apply {
            txtUser.text=user
        }

    }
}