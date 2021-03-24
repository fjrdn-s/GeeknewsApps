package com.indev.geeknewsapps.ui.setting.help

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indev.geeknewsapps.R
import kotlinx.android.synthetic.main.activity_help_setting.*

class HelpSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_setting)

        iv_back.setOnClickListener {
            onBackPressed()
        }
    }
}