package com.vivekgroup.teksunproject.ApiAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.vivekgroup.teksunproject.Apicall.showlistItem
import com.vivekgroup.teksunproject.MainActivity2
import com.vivekgroup.teksunproject.MainActivity3
import com.vivekgroup.teksunproject.R

class ShowAdapter( var showlist:ArrayList<showlistItem>, val context: Context,):RecyclerView.Adapter<ShowAdapter.Myclass>(){
//    class MyAdapter(private val data: ArrayList<DataItem>, private val context: Context): RecyclerView.Adapter<MyAdapter.Myclass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowAdapter.Myclass {
       val view =LayoutInflater.from(context).inflate(R.layout.custom,parent,false)
        return Myclass(view)
    }

    override fun onBindViewHolder(holder: ShowAdapter.Myclass, position: Int) {
//       holder.txt1.text= showlist[position].schemeCode.toString()
//        holder.txt2.text=showlist[position].schemeName
        holder.txt1.text = showlist[position].schemeCode?.toString() ?: ""
        holder.txt2.text = showlist[position].schemeName ?: "" //        intent.putExtra("categoryid", arrayList[adapterPosition].getId())
        holder.card.setOnClickListener {
            val intent =Intent (context, MainActivity3::class.java)
            intent.putExtra("schemeid",showlist[position].schemeCode.toString())
            intent.putExtra("schemename",showlist[position].schemeName)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int =showlist.size

    class Myclass(view: View):RecyclerView.ViewHolder(view) {
        var txt1 =view.findViewById<TextView>(R.id.textView1)
        var txt2 =view.findViewById<TextView>(R.id.textView2)
        var card =view.findViewById<CardView>(R.id.cart)






    }
    fun updateData(newData: List<showlistItem>) {
        showlist.clear()
        showlist.addAll(newData)
        notifyDataSetChanged()
    }
}

