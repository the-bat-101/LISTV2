package com.example.listv2

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.list_View)
        val imageView: ImageView = findViewById(R.id.imageView)

        val listitems = arrayOf("GRIFFISH", "zod", "Skull")
        val imageMap = mapOf(
            "GRIFFISH" to R.drawable.griffith,
            "zod" to R.drawable.zod,
            "Skull" to R.drawable.skull
        )

        val listadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listitems)
        listView.adapter = listadapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            val imageRes = imageMap[selectedItem]

            if (imageRes != null) {
                imageView.setImageResource(imageRes)
                imageView.visibility = View.VISIBLE
            }
        }
    }
}