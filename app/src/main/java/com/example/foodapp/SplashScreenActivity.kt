package com.example.foodapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.foodapp.ViewModel.SharedViewModel
import com.example.foodapp.databinding.ActivitySplashScreenBinding
import com.example.foodapp.fragment.*
import com.example.foodapp.model.Menu
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class SplashScreenActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivitySplashScreenBinding
    private lateinit var sharedViewModel:SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)
        sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        sharedViewModel.menuItemSelected.observe(this,{
            binding.barlayout.tvName.text=it.name
            binding.barlayout.tvTitle.text=it.title
        })
        replaceFragment(HomeFragment())

        binding.navigationView.setNavigationItemSelectedListener {
            onNavigationItemSelected(it)
        }
        binding.barlayout.menu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        setSupportActionBar(binding.barlayout.toolbar)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                replaceFragment(ProfileFragment())
                binding.drawerLayout.close()
                item.isChecked = true
            }
            R.id.wishlist -> {
                replaceFragment(WishListFragment())
                binding.drawerLayout.close()
                item.isChecked = true
            }
            R.id.medal -> {
                replaceFragment(PointsFragment())
                binding.drawerLayout.close()
                item.isChecked = true
            }
            R.id.payment -> {
                replaceFragment(PaymentFragment())
                binding.drawerLayout.close()
                item.isChecked = true
            }
        }
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.close()
        } else {
            super.onBackPressed()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}


