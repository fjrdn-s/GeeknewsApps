package com.indev.geeknewsapps.register

import android.content.Intent
import android.os.Bundle
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

        Glide.with(this)
            .load(currentUser?.photoUrl)
            .into(iv_profile)
        tv_fullName.text = currentUser?.displayName
        tv_emailUser.text = currentUser?.email

        btn_successRegist.setOnClickListener {
            val btnSuccessRegist = Intent(this, MainActivity::class.java)
            startActivity(btnSuccessRegist)
            finishAffinity()
        }
    }
}