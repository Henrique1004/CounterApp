package com.example.counterapp

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicializa o View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.out.text = counter.toString()

        binding.btnRemove.setOnClickListener {
            if(ehZero(counter)){
                showAlert()
            }
            else {
                counter -= 1
                binding.out.text = counter.toString()
            }
        }

        binding.btnAdd.setOnClickListener {
            counter += 1
            binding.out.text = counter.toString()
        }

        binding.rButton.setOnClickListener {
            counter = 0
            binding.out.text = counter.toString()
        }
    }
    fun showAlert() {
        // Criar o AlertDialog.Builder
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Aviso")
        builder.setMessage("Não é posível números negativos.")
        builder.setPositiveButton("OK") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        // Exibir o AlertDialog
        val alertDialog = builder.create()
        alertDialog.show()
    }

    fun ehZero(num : Int) : Boolean{
        if (num == 0) return true
        return false
    }
}