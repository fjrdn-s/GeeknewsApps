package com.indev.geeknewsapps.ui.trending.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.ui._model.ModelData
import com.indev.geeknewsapps.ui.detail.DetailActivity
import java.util.*

class TrendingVerticalAdapter (
        private val listVertical: ArrayList<ModelData>
) : RecyclerView.Adapter<TrendingVerticalAdapter.TechVerticalViewHolder>() {

    inner class TechVerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        var tvCategory: TextView = itemView.findViewById(R.id.tv_category)
        var tvPostTime: TextView = itemView.findViewById(R.id.tv_postTime)
        var imgPoster: ImageView = itemView.findViewById(R.id.iv_poster)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingVerticalAdapter.TechVerticalViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home_vertical, parent, false)
        return TechVerticalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listVertical.size
    }

    override fun onBindViewHolder(holder: TrendingVerticalAdapter.TechVerticalViewHolder, position: Int) {

        val rcVertical = listVertical[position]

        Glide.with(holder.itemView.context)
                .load(rcVertical.imagesUrl)
                .apply(RequestOptions()
                        .override(70, 70)
                        .transform(CenterCrop(), RoundedCorners(8)))
                .into(holder.imgPoster)
        holder.tvTitle.text = rcVertical.title
        holder.tvCategory.text = rcVertical.category
        holder.tvPostTime.text = rcVertical.postTime

        val intentDetail= holder.itemView.context

        holder.itemView.setOnClickListener {
            val mvDetail= Intent(intentDetail, DetailActivity::class.java)
            mvDetail.putExtra(DetailActivity.EXTRA_TITLE, rcVertical.title)
            mvDetail.putExtra(DetailActivity.EXTRA_DESCRIPTION, rcVertical.description)
            mvDetail.putExtra(DetailActivity.EXTRA_CATEGORY, rcVertical.category)
            mvDetail.putExtra(DetailActivity.EXTRA_POSTTIME, rcVertical.postTime)
            mvDetail.putExtra(DetailActivity.EXTRA_POSTBY, rcVertical.postBy)
            mvDetail.putExtra(DetailActivity.EXTRA_IMAGES, rcVertical.imagesUrl)
            mvDetail.putExtra(DetailActivity.EXTRA_VIDEO, rcVertical.youtubeUrl)

            intentDetail.startActivity(mvDetail)
        }
    }
}