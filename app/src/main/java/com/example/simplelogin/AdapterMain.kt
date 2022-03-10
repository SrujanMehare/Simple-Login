package com.example.simplelogin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterMain: RecyclerView.Adapter<AdapterMain.UsersViewHolder>() {
    val userList= arrayListOf(" name,name1,name2")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val li = LayoutInflater.from(parent.context)
        val itemView = li.inflate(R.layout.home_screen, parent, false)
        return UsersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.username.text = userList[position]
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val username = itemView.findViewById<TextView>(R.id.tv)
    }
}