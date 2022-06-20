package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.MenuItemBinding
import com.example.foodapp.model.Data


class MenuAdapter(
    var list: List<Data>,var listener:IOnItemClickListener
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

//    var list: List<Data> = listOf()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val menuItemBinding = MenuItemBinding.inflate(inflater, parent, false)
        return MenuViewHolder(menuItemBinding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
//        holder.onBind(list[position])
        holder.menuItemBinding.dataItem = list[position]
        holder.menuItemBinding.imgDish.setImageResource(list[position].image)
        holder.menuItemBinding.tvName.text=list[position].name
        holder.menuItemBinding.tvDescription.text=list[position].description
        holder.menuItemBinding.root.setOnClickListener {
            listener.onItemClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MenuViewHolder(val menuItemBinding: MenuItemBinding) :
        RecyclerView.ViewHolder(menuItemBinding.root)
//    {
//        fun onBind(data: Data) {
//            menuItemBinding.dataItem = data
//            menuItemBinding.root.setOnClickListener {
//
//            }
//        }
//
//    }

    interface IOnItemClickListener {
        fun onItemClick(data: Data)
    }
}