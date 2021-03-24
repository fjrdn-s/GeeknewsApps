package com.indev.geeknewsapps.ui.setting.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indev.geeknewsapps.R
import kotlinx.android.synthetic.main.activity_profile_setting.*

class ProfileSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_setting)

        iv_back.setOnClickListener {
            onBackPressed()
        }
    }
}