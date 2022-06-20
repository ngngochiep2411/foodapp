package com.example.foodapp.adapter

import android.content.Context
import android.widget.BaseAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.foodapp.R
import android.widget.TextView

class SpinnerAditionsAdapter(var additions: List<String>, var context: Context) : BaseAdapter() {
    override fun getCount(): Int {
        return additions.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.layout_spinner_item_additions, parent, false)
        val tvItemAddition = view.findViewById<TextView>(R.id.tvItemAddition)
        tvItemAddition.text = additions[position]
        return view
    }
}