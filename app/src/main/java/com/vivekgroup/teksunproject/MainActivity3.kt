package com.vivekgroup.teksunproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

private val sharedcodes ="share"
private val RANDOM_NUMBER_KEY = "random_number_key"
class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val schemecode =intent.getStringExtra("schemeid")
        val schemename =intent.getStringExtra("schemename")
        val sharedPreferences:SharedPreferences =this.getSharedPreferences(sharedcodes,Context.MODE_PRIVATE)
        findViewById<TextView>(R.id.textView002).apply {text=schemecode.toString() }
        findViewById<TextView>(R.id.textView102).apply { text=schemename.toString() }

       findViewById<Button>(R.id.butsave).apply {
           val random = Random
           val randomNumber = random.nextInt()
           val editor:SharedPreferences.Editor = sharedPreferences.edit()
           editor.putString("$randomNumber","schemecode is :"+"   "+schemecode.toString()+"   "+"schemename is :"+"   "+schemename)
           editor.apply()
           editor.commit()

           mov()



       }

    }
    fun mov(){
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
    }



    private fun generateRandomNumber(): Int {
        // Create a Random object
        val random = kotlin.random.Random

        // Generate a random integer
        return random.nextInt()
    }

//    public fun deletedata(){
//
//        val editor = sharedPreferences.edit()
//        editor.clear()
//        editor.apply()
//    }

}