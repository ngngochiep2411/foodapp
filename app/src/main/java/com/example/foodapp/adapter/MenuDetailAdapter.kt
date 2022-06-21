package com.example.foodapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.Interface.IOnItemClickDetailMenu
import com.example.foodapp.databinding.ItemMenuDetailBinding
import com.example.foodapp.databinding.MenuItemBinding
import com.example.foodapp.model.MenuItem

class MenuDetailAdapter(val context: Context,val list: List<MenuItem>,val iOnItemClickDetailMenu: IOnItemClickDetailMenu) : RecyclerView.Adapter<MenuDetailAdapter.MenuDetailViewHolder>() {

    inner class MenuDetailViewHolder( val binding: ItemMenuDetailBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val menuItemBinding = ItemMenuDetailBinding.inflate(inflater, parent, false)
        return MenuDetailViewHolder(menuItemBinding)
    }

    override fun onBindViewHolder(holder: MenuDetailViewHolder, position: Int) {
        val item : MenuItem = list[position]
        holder.binding.menuItem = item
        holder.binding.btnBuyNow.setOnClickListener {
            iOnItemClickDetailMenu.clickItemMenu(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}