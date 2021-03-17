package com.indev.geeknewsapps.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.register.RegisterActivity
import com.indev.geeknewsapps.register.SuccessRegistActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_regist.setOnClickListener {
            val btnRegist = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(btnRegist)
        }

        btn_login.setOnClickListener {
            val btnLogin = Intent(this@LoginActivity, SuccessRegistActivity::class.java)
            startActivity(btnLogin)
        }
    }
}