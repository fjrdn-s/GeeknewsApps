package com.indev.geeknewsapps.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.onboarding.OnboardingActivity
import com.indev.geeknewsapps.register.SuccessRegistActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        Handler().postDelayed({
            if (user != null) {
                val successIntent = Intent(this, SuccessRegistActivity::class.java)
                startActivity(successIntent)
            } else {
                val obIntent = Intent(this, OnboardingActivity::class.java)
                startActivity(obIntent)
            }
            finish()
        }, 3000)
    }
}