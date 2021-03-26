package com.indev.geeknewsapps.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indev.geeknewsapps.MainActivity
import com.indev.geeknewsapps.R
import kotlinx.android.synthetic.main.activity_success_regist.*

class SuccessRegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_regist)
//
        btn_successRegist.setOnClickListener {
            val btnSuccessRegist = Intent(this, MainActivity::class.java)
            startActivity(btnSuccessRegist)
            finishAffinity()
        }
    }
}