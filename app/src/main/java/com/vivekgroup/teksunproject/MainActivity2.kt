package com.vivekgroup.teksunproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vivekgroup.teksunproject.ApiAdapter.ShowAdapter
import com.vivekgroup.teksunproject.Apicall.Apiclient
import com.vivekgroup.teksunproject.Apicall.Apinterface
import com.vivekgroup.teksunproject.Apicall.showlistItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var searchView: SearchView
    lateinit var showAdapter: ShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        searchView = findViewById(R.id.searchView)
        recyclerView=findViewById(R.id.list)
        recyclerView.layoutManager=LinearLayoutManager(this)
        showAdapter = ShowAdapter(ArrayList(), this@MainActivity2) // Initialize with an empty list
        recyclerView.adapter = showAdapter
        try {
            val Api: Apinterface = Apiclient().getApiClient()!!.create(Apinterface::class.java)
            Api.getdata().enqueue(object : Callback<ArrayList<showlistItem>> {
                override fun onResponse(
                    call: Call<ArrayList<showlistItem>>,
                    response: Response<ArrayList<showlistItem>>
                ) {
                 showAdapter.updateData(response.body()!!)
                }

                override fun onFailure(call: Call<ArrayList<showlistItem>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

    }catch (e:Exception){
        Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
    }
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(newText: String?): Boolean {
               performSearch(newText)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                performSearch(newText)
                return true
            }

        })


    }

    private fun performSearch(query: String?) {
        if (query.isNullOrBlank()){
            return
        }
        val api: Apinterface = Apiclient().getApiClient()!!.create(Apinterface::class.java)
        api.search(query.orEmpty()).enqueue(object : Callback<ArrayList<showlistItem>> {
            override fun onResponse(
                call: Call<ArrayList<showlistItem>>,
                response: Response<ArrayList<showlistItem>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                   showAdapter.updateData(response.body()!!)
                } else {
                    // Handle the case where the response is not successful or the body is null
                    Toast.makeText(
                        this@MainActivity2,
                        "Search failed: ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<showlistItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity2, "Search failed: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}