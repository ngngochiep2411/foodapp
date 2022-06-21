package com.example.foodapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.Interface.IOnItemClickMenu
import com.example.foodapp.R
import com.example.foodapp.ViewModel.SharedViewModel
import com.example.foodapp.adapter.MenuAdapter
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.model.Menu
import com.example.foodapp.model.MenuItem
import kotlinx.android.synthetic.main.layout_toolbar.*


class HomeFragment : Fragment(), IOnItemClickMenu {

    lateinit var adapter: MenuAdapter
    lateinit var binding: FragmentHomeBinding
    var viewModel: SharedViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)
        setuprcv()
        return binding.root
    }


    private fun setuprcv() {
        binding.rvListCategory.layoutManager = LinearLayoutManager(context)
        adapter = MenuAdapter(createData(), this)
        adapter.list = createData()
        binding.rvListCategory.adapter = adapter
        binding.rvListCategory.setHasFixedSize(true)

    }

    private fun createData(): MutableList<Menu> {

        val listMenuItem1 = mutableListOf<MenuItem>()
        listMenuItem1.add(MenuItem(R.drawable.fired_rice, "Fried Rice"))
        listMenuItem1.add(MenuItem(R.drawable.rice2, "Jollof Rice"))

        val listMenuItem2 = mutableListOf<MenuItem>()
        listMenuItem2.add(MenuItem(R.drawable.chicken, "Shawarma"))
        listMenuItem2.add(MenuItem(R.drawable.cheesy_bread, "Cheesy Bread"))

        val listMenu = mutableListOf<Menu>()
        listMenu.add(
            Menu(
                R.drawable.sumptous1,
                "Main Dishes",
                "(355 ratings)  - Starts at ₦2500",
                "Find the best selling dishes. All meals are preparred fresh. ",
                listMenuItem1
            )
        )
        listMenu.add(
            Menu(
                R.drawable.sumptous1,
                "Best Sellers",
                "(105 ratings)  - Starts at ₦2000",
                "Everyone’s favourite dishes and takeouts. ",
                listMenuItem2
            )
        )

        return listMenu


    }

    override fun onResume() {
        super.onResume()
        activity?.tvName?.text=getString(R.string.tvNameHomeFragment)
        activity?.tvTitle?.text=getString(R.string.titleHomeFragment)
    }


    override fun clickItemMenu(menu: Menu) {
        Log.d("menu", menu.toString());
        viewModel?.setMenuSelected(menu)
        val transaction: FragmentTransaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.replace(R.id.container, MenuDetailFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }


}