package com.indev.geeknewsapps.register

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indev.geeknewsapps.R
import kotlinx.android.synthetic.main.activity_user_profiling.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class UserProfilingActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profiling)

        toolbar_category.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_black, null)
        toolbar_category.setNavigationOnClickListener {
            onBackPressed()
        }

        ib_tech.setOnClickListener {
            val btnSuccessRegist = Intent(this, SuccessRegistActivity::class.java)
            startActivity(btnSuccessRegist)
        }
    }
}