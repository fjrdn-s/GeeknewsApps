package com.indev.geeknewsapps.ui.category.event

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indev.geeknewsapps.R
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_category_event.*

class CategoryEventActivity : AppCompatActivity() {

    val crImages = intArrayOf(
        R.drawable.img_3,
        R.drawable.img_1,
        R.drawable.img_5,
        R.drawable.img_2
    )

    val imagesListener = ImageListener {
            position, imageView ->
        imageView.setImageResource(crImages[position])
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_event)

        carouselView.pageCount = crImages.size
        carouselView.setImageListener(imagesListener)
    }
}