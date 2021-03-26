package com.indev.geeknewsapps.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.indev.geeknewsapps.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbar_detail.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_white, null)
        toolbar_detail.setNavigationOnClickListener {
            onBackPressed()
        }

        val tTitle = intent.getStringExtra(EXTRA_TITLE)
        val tDescription = intent.getStringExtra(EXTRA_DESCRIPTION)
        val tCategory = intent.getStringExtra(EXTRA_CATEGORY)
        val tPostTime = intent.getStringExtra(EXTRA_POSTTIME)
        val tPostBy = intent.getStringExtra(EXTRA_POSTBY)
        val iPoster = intent.getStringExtra(EXTRA_IMAGES)

        tv_title.text = tTitle
        tv_description.text = tDescription
        tv_category.text = tCategory
        tv_postTime.text = tPostTime
        tv_postBy.text = tPostBy
        Glide.with(this)
                .load(iPoster)
                .apply(RequestOptions())
                .into(iv_poster)
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_CATEGORY = "extra_category"
        const val EXTRA_POSTTIME = "extra_postTime"
        const val EXTRA_POSTBY = "extra_postBy"
        const val EXTRA_IMAGES = "extra_images"
    }
}