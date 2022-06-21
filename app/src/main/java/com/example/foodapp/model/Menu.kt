package com.example.foodapp.model

import java.io.Serializable

data class Menu(var image: Int, var name: String, var description: String,val title:String,val menuItem:List<MenuItem>):Serializable