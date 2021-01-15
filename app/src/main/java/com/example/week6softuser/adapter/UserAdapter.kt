package com.example.week6softuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week6softuser.Data
import com.example.week6softuser.R
import kotlin.collections.ArrayList

class UserAdapter(
    val userdata: ArrayList<Data>,
    val context:Context
    ):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val userimg:ImageView
        val tvname: TextView
        val tvage: TextView
        val tvaddress: TextView
        val tvgender: TextView
        val ivdelete: ImageView

        init {
            userimg=view.findViewById(R.id.userimg)
            tvname=view.findViewById(R.id.tvname)
            tvage=view.findViewById(R.id.tvage)
            tvaddress=view.findViewById(R.id.tvaddress)
            tvgender=view.findViewById(R.id.tvgender)
            ivdelete=view.findViewById(R.id.ivdelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_userdesign,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userdata[position]
        holder.tvname.text = user.Fullname
        holder.tvage.text = ("${user.Age}")
        holder.tvaddress.text = user.Address
        holder.tvgender.text = user.Gender
        if(user.Gender == "Female"){
            Glide.with(context)
                    .load("https://secureservercdn.net/160.153.137.99/ee1.6f6.myftpupload.com/wp-content/uploads/2019/01/bio-thumb-female-default.png?time=1606544555")
                    .into(holder.userimg)
        }
        else if (user.Gender == "Male"){
            Glide.with(context)
                    .load("https://uoch.edu.pk/wp-content/uploads/2017/11/default-male-photo.png")
                    .into(holder.userimg)
        }
        else if (user.Gender == "Others"){
            Glide.with(context)
                .load("https://uoch.edu.pk/wp-content/uploads/2017/11/default-male-photo.png")
                .into(holder.userimg)
        }
        holder.ivdelete.setOnClickListener{
            userdata.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return userdata.size
    }
}