package com.indev.geeknewsapps.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.onboarding.OnboardingActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val auth = Intent(this@SplashScreenActivity, OnboardingActivity::class.java)
            startActivity(auth)
            finish()
        }, 3000)
    }
}