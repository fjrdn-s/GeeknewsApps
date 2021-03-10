package com.indev.geeknewsapps.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indev.geeknewsapps.R
import kotlinx.android.synthetic.main.activity_user_profiling.*

class UserProfilingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profiling)

        ib_tech.setOnClickListener {
            val btnSuccessRegist = Intent(this@UserProfilingActivity, SuccessRegistActivity::class.java)
            startActivity(btnSuccessRegist)
        }
    }
}