package com.example.recyclesubmission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListDevAdapter(private val listDev: ArrayList<Developer>, private val ClickedPage:BtnDetailPage):RecyclerView.Adapter<ListDevAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatarPhoto:ImageView = itemView.findViewById(R.id.img_item_dev)
        var tvName:TextView = itemView.findViewById(R.id.tv_item_dev)
        var tvUsername:TextView = itemView.findViewById(R.id.tv_item_username)
        var tvLoc:TextView = itemView.findViewById(R.id.tv_item_loc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_developer, parent,false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (userName, name, location, repository, company, followers, following,avatar) = listDev[position]

        Glide.with(holder.itemView.context).load(avatar).circleCrop().into(holder.avatarPhoto)
        holder.tvName.text = name
        holder.tvUsername.text = userName
        holder.tvLoc.text = location
        holder.itemView.setOnClickListener { ClickedPage.clickedItem(position) }
    }
    interface BtnDetailPage{
        fun clickedItem(id:Int)
    }

    override fun getItemCount(): Int = listDev.size
}