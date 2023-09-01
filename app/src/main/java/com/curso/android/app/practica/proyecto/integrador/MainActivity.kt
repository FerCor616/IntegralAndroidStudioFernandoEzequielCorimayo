package com.curso.android.app.practica.proyecto.integrador

import com.curso.android.app.practica.proyecto.integrador.view.MyViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.practica.proyecto.integrador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        binding.buttonCompare.setOnClickListener {
            val texto1 = binding.editText1.text.toString()
            val texto2 = binding.editText2.text.toString()
            viewModel.compareTexts(texto1, texto2)
            println("botton ha sido llamada")
        }

        viewModel.compare.observe(this, Observer { compare ->
            binding.textView.text = compare.resultado
            println("observer ha sido llamada")
        })
    }
}
