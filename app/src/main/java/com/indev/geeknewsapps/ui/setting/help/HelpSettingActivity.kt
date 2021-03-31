package com.indev.geeknewsapps.ui.setting.help

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.indev.geeknewsapps.R
import kotlinx.android.synthetic.main.activity_help_setting.*

class HelpSettingActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_setting)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        if (currentUser != null) {
            if (currentUser.photoUrl != null) {
                Glide.with(this)
                        .load(currentUser.photoUrl)
                        .into(iv_profile)
            } else {
                Glide.with(this)
                        .load("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1200px-No_image_available.svg.png")
                        .into(iv_profile)
            }
        }

        if (currentUser != null) {
            if (currentUser.displayName != null) {
                tv_fullName.text = currentUser.displayName
            } else {
                tv_fullName.text = currentUser.uid
            }
        }

        tv_emailUser.text = currentUser?.email

        iv_back.setOnClickListener {
            onBackPressed()
        }


    }
}