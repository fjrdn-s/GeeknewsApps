package com.indev.geeknewsapps.ui.home.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.ui.home._model.HomeHorizontal
import java.util.*

class EventVerticalAdapter (
        private val listVerticalTech: ArrayList<HomeHorizontal>
) : RecyclerView.Adapter<EventVerticalAdapter.TechVerticalViewHolder>() {

    inner class TechVerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        var tvCategory: TextView = itemView.findViewById(R.id.tv_category)
        var tvPostTime: TextView = itemView.findViewById(R.id.tv_postTime)
        var imgPhoster: ImageView = itemView.findViewById(R.id.iv_poster)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventVerticalAdapter.TechVerticalViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home_vertical, parent, false)
        return TechVerticalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listVerticalTech.size
    }

    override fun onBindViewHolder(holder: EventVerticalAdapter.TechVerticalViewHolder, position: Int) {

        val verticalTech = listVerticalTech[position]

        Glide.with(holder.itemView.context)
                .load(verticalTech.images)
                .apply(RequestOptions().override(70, 70))
                .into(holder.imgPhoster)
        holder.tvTitle.text = verticalTech.title
        holder.tvCategory.text = verticalTech.category
        holder.tvPostTime.text = verticalTech.postTime
    }

}