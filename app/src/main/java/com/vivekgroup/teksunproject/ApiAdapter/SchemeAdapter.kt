package com.vivekgroup.teksunproject.ApiAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vivekgroup.teksunproject.Apicall.SchemeData
import com.vivekgroup.teksunproject.R

class SchemeAdapter(private val dataList: List<SchemeData>) : RecyclerView.Adapter<SchemeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.secustom, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val schemeData = dataList[position]
        holder.bind(schemeData)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt1 = itemView.findViewById<TextView>(R.id.textView03)
        var txt2 = itemView.findViewById<TextView>(R.id.textView04)

        fun bind(schemeData: SchemeData) {
            txt1.text = schemeData.schemeCode
            txt2.text = schemeData.schemeName
        }
    }
}
