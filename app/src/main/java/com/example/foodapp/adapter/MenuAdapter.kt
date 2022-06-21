package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.Interface.IOnItemClickMenu
import com.example.foodapp.databinding.MenuItemBinding
import com.example.foodapp.model.Menu


class MenuAdapter(
    var list: List<Menu>, private var listener:IOnItemClickMenu
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val menuItemBinding = MenuItemBinding.inflate(inflater, parent, false)
        return MenuViewHolder(menuItemBinding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
//        holder.onBind(list[position])
        val menu : Menu = list[position]
        holder.menuItemBinding.dataItem = menu
//        holder.menuItemBinding.imgDish.setImageResource(list[position].image)
//        holder.menuItemBinding.tvName.text=list[position].name
//        holder.menuItemBinding.tvDescription.text=list[position].description
        holder.menuItemBinding.root.setOnClickListener {
            listener.clickItemMenu(menu)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MenuViewHolder(val menuItemBinding: MenuItemBinding) :
        RecyclerView.ViewHolder(menuItemBinding.root)

}