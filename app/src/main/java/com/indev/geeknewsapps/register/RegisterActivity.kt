package com.indev.geeknewsapps.register

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.indev.geeknewsapps.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        toolbar_category.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_black, null)
        toolbar_category.setNavigationOnClickListener {
            onBackPressed()
        }

        btn_regist.setOnClickListener {
            requestRegist()
        }
    }

    private fun requestRegist() {
        val email = et_emailAddress.text.toString().trim()
        val password = et_password.text.toString().trim()
        val confirmPassword = et_confirmPassword.text.toString().trim()

        if (email.isEmpty()) {
            et_emailAddress.error = "Please enter email address!"
            et_emailAddress.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_emailAddress.error = "Invalid email!"
            et_emailAddress.requestFocus()
            return
        }

        if (password.isEmpty() || password.length < 6) {
            et_password.error = "Password must between 6 to 16 character"
            et_password.requestFocus()
            return
        }

        if (password != confirmPassword) {
            et_confirmPassword.error = "Password not match"
            et_confirmPassword.requestFocus()
            return
        }

        registerUser(email, password)
    }

    private fun registerUser(email: String, password: String) {
        val progressBar = Dialog(this)
        progressBar.setContentView(R.layout.dialog_progressbar)
        progressBar.show()

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        val profillingIntent = Intent(this, UserProfilingActivity::class.java)
                        startActivity(profillingIntent)
                        finish()
                    } else {
                        Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                    }

                    progressBar.setCancelable(false)
                    progressBar.dismiss()
                }
    }
}