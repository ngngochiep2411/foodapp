package com.example.foodapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.model.Menu
import com.example.foodapp.model.MenuItem

class SharedViewModel : ViewModel() {

    val menuItemSelected = MutableLiveData<Menu>()
    val menuItemDetailSelected = MutableLiveData<MenuItem>()

    fun setMenuSelected(menu: Menu) {
        menuItemSelected.value = menu
    }

    fun setMenuDetailSelected(menuItem: MenuItem) {
        menuItemDetailSelected.value=menuItem
    }


}