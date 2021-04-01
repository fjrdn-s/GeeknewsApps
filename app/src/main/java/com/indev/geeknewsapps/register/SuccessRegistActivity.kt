package com.indev.geeknewsapps.register

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.indev.geeknewsapps.MainActivity
import com.indev.geeknewsapps.R
import kotlinx.android.synthetic.main.activity_success_regist.*

class SuccessRegistActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_regist)

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
                tv_fullName.text = currentUser.isAnonymous.toString()
            }
        }

        tv_emailUser.text = currentUser?.email

//        btn_successRegist.setOnClickListener {
//            val btnSuccessRegist = Intent(this, MainActivity::class.java)
//            startActivity(btnSuccessRegist)
//            finishAffinity()
//        }

        Handler().postDelayed({
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 4000)

    }
}