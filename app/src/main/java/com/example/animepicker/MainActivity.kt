package com.example.animepicker

import android.R.attr.data
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinner)

        val animeList = arrayOf(
            "Jujutsu Kaisen",
            "Hunter X Hunter",
            "Dragon Ball",
            "Death Note",
            "One Piece",
            "Attack on Titan",
            "One Punch Man",
            "Pokémon",
            "Parasyte: The Maxim",
            "Naruto Shippuden",
            "Bleach",
            "Solo Leveling",
            "Demon Slayer",
            "My Hero Academia",
            "Spirited Away",
            "My Neighbor Totoro",
            "Kiki’s Delivery Service",
            "Ponyo",
            "The Cat Returns",
            "Arrietty",
        )

        val adapter =
            ArrayAdapter(this,android.R.layout.simple_spinner_item,animeList)


        spinner.adapter =  adapter
        var selection = true

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                p: AdapterView<*>?,
                v: View?,
                position: Int,
                id: Long
            ) {
                if (selection)
                    selection = false
                else{
                    val intent = Intent(Intent.ACTION_VIEW,"https://www.google.com/search?q=${animeList[position]}".toUri())
                    startActivity(intent)
                }



            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }




    }
}