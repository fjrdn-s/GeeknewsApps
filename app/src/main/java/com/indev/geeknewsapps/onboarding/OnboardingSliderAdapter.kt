package com.indev.geeknewsapps.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.indev.geeknewsapps.R

class OnboardingSliderAdapter(private val onboardingSlider: List<OnboardingSlider>) :
    RecyclerView.Adapter<OnboardingSliderAdapter.onboardingSliderViewHolder>() {

    inner class onboardingSliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.tv_titleOb)
        private val textDescription = view.findViewById<TextView>(R.id.tv_descriptionOb)
        private val imageIcon = view.findViewById<ImageView>(R.id.iv_posterOb)

        fun bind(onboardingSlider: OnboardingSlider) {
            textTitle.text = onboardingSlider.title
            textDescription.text = onboardingSlider.description
            imageIcon.setImageResource(onboardingSlider.icon)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): onboardingSliderViewHolder {
        return onboardingSliderViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_slide_onboarding, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return onboardingSlider.size
    }

    override fun onBindViewHolder(
        holder: onboardingSliderViewHolder,
        position: Int
    ) {
        holder.bind(onboardingSlider[position])
    }

}