package com.example.week6softuser.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceControl.Transaction
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6softuser.Data
import com.example.week6softuser.MainActivity
import com.example.week6softuser.R
import com.example.week6softuser.adapter.UserAdapter


class HomeFragment : Fragment() {

//    var userdata = ArrayList<Data>()
    private lateinit var rvuser:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        loaduser()
        rvuser=view.findViewById(R.id.rvuser)

        val adapteruser = UserAdapter(userdata, this.activity as Context)
        rvuser.layoutManager= LinearLayoutManager(this.activity as Context)
        rvuser.adapter = adapteruser

        return view
    }

    private fun loaduser(){
        if(userdata.size == 0){
            userdata.add(Data("Salman Khan", 52, "Male", "India"))
            userdata.add(Data("Saaz Neupane", 20, "Male", "Koteshwor"))
            userdata.add(Data("Katrina Kaif", 45, "Female", "India"))
        }

    }

    companion object{
        var userdata = ArrayList<Data>()
    }
}