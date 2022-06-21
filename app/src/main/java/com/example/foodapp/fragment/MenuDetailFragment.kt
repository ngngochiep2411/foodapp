package com.example.foodapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp.Interface.IOnItemClickDetailMenu
import com.example.foodapp.R
import com.example.foodapp.ViewModel.SharedViewModel
import com.example.foodapp.adapter.MenuDetailAdapter
import com.example.foodapp.databinding.FragmentMenuDetailBinding
import com.example.foodapp.model.MenuItem

class MenuDetailFragment : Fragment(),IOnItemClickDetailMenu {


    private lateinit var binding: FragmentMenuDetailBinding
    var adapter: MenuDetailAdapter? = null
    var list : List<MenuItem>?=null
    lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu_detail, container, false)
        viewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)
        viewModel.menuItemSelected.observe(requireActivity(), {
            Log.d("MenuDetailFragment",it.toString())
            list=it.menuItem

        })
        adapter =  MenuDetailAdapter(requireActivity(), list!!,this)
        binding.rcvMenuDetail.layoutManager=GridLayoutManager(requireContext(),2)
        binding.rcvMenuDetail.adapter=adapter


        return binding.root
    }

    override fun clickItemMenu(menuItem: MenuItem) {
        Log.d("MenuDetailFragment",menuItem.toString())
        viewModel.setMenuDetailSelected(menuItem)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,FragmentProductDetail())
        transaction.addToBackStack(null)
        transaction.commit()
    }


}