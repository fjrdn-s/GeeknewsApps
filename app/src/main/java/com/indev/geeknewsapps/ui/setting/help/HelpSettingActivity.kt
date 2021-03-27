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

        iv_back.setOnClickListener {
            onBackPressed()
        }

        Glide.with(this)
            .load(currentUser?.photoUrl)
            .into(iv_profile)
        tv_fullName.text = currentUser?.displayName
        tv_emailUser.text = currentUser?.email
    }
}