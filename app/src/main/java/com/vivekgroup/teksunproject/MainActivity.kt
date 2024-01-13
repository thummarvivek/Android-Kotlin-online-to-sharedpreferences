package com.vivekgroup.teksunproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vivekgroup.teksunproject.ApiAdapter.SchemeAdapter
import com.vivekgroup.teksunproject.Apicall.SchemeData
private val sharedcodes ="share"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences(sharedcodes, MODE_PRIVATE)
        val dataMap = sharedPreferences.all as Map<String, String>
        val dataList = dataMap.values.toList()
        val recyclerView = findViewById<RecyclerView>(R.id.list)
//        val adapter = SchemeAdapter(dataList.map { parseSchemeData(it) }) // Assume parseSchemeData is a function to convert string to SchemeData
       val adapter=SchemeAdapter(dataList.map { parseSchemeData(it) } )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun parseSchemeData(data: String): SchemeData {
        // Implement the logic to parse the string and create a SchemeData object
        val parts = data.split("schemecode is :   ", "schemename is :   ")
        return SchemeData(parts[1].trim(), parts[2].trim())
    }
    fun onmbtn(view: View){
        val intent = Intent (this, MainActivity2::class.java)
        startActivity(intent)

    }
}