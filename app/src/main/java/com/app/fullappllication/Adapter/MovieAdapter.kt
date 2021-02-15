package com.app.fullappllication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.fullappllication.Model.Movie
import com.app.fullappllication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class MovieAdapter(private val context: Context, private val movieList: MutableList<Movie>)
    : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val image: ImageView=itemView.image_movie
        val txt_name: TextView = itemView.txt_name
        val txt_team: TextView = itemView.txt_team
        val txt_createdby: TextView = itemView.txt_createdby

        fun bind(listItem :Movie){
            image.setOnClickListener { Toast.makeText(it.context, "${itemView.image_movie} CLICKED", Toast.LENGTH_SHORT).show() }
            itemView.setOnClickListener { Toast.makeText(it.context, "${itemView.txt_name.text} CLICKED", Toast.LENGTH_SHORT).show() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem=movieList[position]
        holder.bind(listItem)

        Picasso.get().load(listItem.imageurl).into(holder.image)
        holder.txt_name.text=listItem.name
        holder.txt_team.text=listItem.team
        holder.txt_createdby.text=listItem.createdby
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}