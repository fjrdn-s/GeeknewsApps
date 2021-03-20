package com.indev.geeknewsapps.ui.trending.adapter

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

class TrendingHorizontalAdapter(
    private val listRecyclerHorizontal: ArrayList<HomeHorizontal>
) : RecyclerView.Adapter<TrendingHorizontalAdapter.HomeHorizontalViewHolder>() {

    inner class HomeHorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        var tvSubTitle: TextView = itemView.findViewById(R.id.tv_subTitle)
        var tvCategory: TextView = itemView.findViewById(R.id.tv_category)
        var tvPostTime: TextView = itemView.findViewById(R.id.tv_postTime)
        var imgPhoster: ImageView = itemView.findViewById(R.id.iv_poster)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingHorizontalAdapter.HomeHorizontalViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_horizontal, parent, false)
        return HomeHorizontalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listRecyclerHorizontal.size
    }

    override fun onBindViewHolder(
        holder: TrendingHorizontalAdapter.HomeHorizontalViewHolder,
        position: Int
    ) {
        val homeHorizontal = listRecyclerHorizontal[position]

        Glide.with(holder.itemView.context)
            .load(homeHorizontal.images)
            .apply(RequestOptions().override(230, 290))
            .into(holder.imgPhoster)
        holder.tvTitle.text = homeHorizontal.title
        holder.tvSubTitle.text = homeHorizontal.subTitle
        holder.tvCategory.text = homeHorizontal.category
        holder.tvPostTime.text = homeHorizontal.postTime
    }
}