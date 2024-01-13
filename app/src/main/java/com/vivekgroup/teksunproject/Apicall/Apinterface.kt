package com.vivekgroup.teksunproject.Apicall

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Apinterface {

    @GET("mf")
    fun getdata():Call<ArrayList<showlistItem>>

  @GET("mf/search")
  fun search(@Query("q") query: String):Call<ArrayList<showlistItem>>
}