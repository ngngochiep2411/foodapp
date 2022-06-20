package com.example.foodapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.foodapp.R
import java.util.*

class PaymentFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_payment, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        return view
    }

    private val listAdditions: List<String>
        get() {
            val list: MutableList<String> = ArrayList()
            list.add("Cơm")
            list.add("Phở")
            list.add("Rau")
            list.add("Cá")
            return list
        }


    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}