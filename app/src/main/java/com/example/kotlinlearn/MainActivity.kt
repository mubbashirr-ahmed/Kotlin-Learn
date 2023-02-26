package com.example.kotlinlearn

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kotlinlearn.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

       clickListeners()

    }

    private fun clickListeners() {
        binding.button.setOnClickListener {
            rollDice()
        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("OK", Model("Mubb", "3"))
            startActivity(intent)
        }
        binding.alert.setOnClickListener {
            showDialog()
        }
        binding.implicitI.setOnClickListener {
            sendIntent()
        }
        binding.recycler.setOnClickListener {
            startActivity(Intent(this, RecyclerViewExample::class.java))
        }

    }

    private fun sendIntent() {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, "Whatever text")
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Choose app"))
    }
    private fun showDialog() {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Mubb")
        alert.setMessage("My first Dialog")
        alert.setPositiveButton("Ok") { _, _ ->
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
        }
        alert.setNegativeButton("Cancel"){_,_->
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
        }
        alert.setCancelable(true)
        alert.create().show()
    }
    private fun rollDice() {
        when(Random.nextInt(0,6) + 1){
            1->binding.image.setImageResource(R.drawable.dice_1)
            2->binding.image.setImageResource(R.drawable.dice_2)
            3->binding.image.setImageResource(R.drawable.dice_3)
            4->binding.image.setImageResource(R.drawable.dice_4)
            5->binding.image.setImageResource(R.drawable.dice_5)
            6->binding.image.setImageResource(R.drawable.dice_6)
            else -> binding.image.setImageResource(R.drawable.empty_dice)
        }
    }
}
