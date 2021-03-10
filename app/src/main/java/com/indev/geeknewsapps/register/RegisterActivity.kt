package com.indev.geeknewsapps.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indev.geeknewsapps.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        ib_regist.setOnClickListener {
            val ibRegist = Intent(this@RegisterActivity, UserProfilingActivity::class.java)
            startActivity(ibRegist)
        }
    }
}