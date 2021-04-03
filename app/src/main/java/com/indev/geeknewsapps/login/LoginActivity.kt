package com.indev.geeknewsapps.login

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.register.RegisterActivity
import com.indev.geeknewsapps.register.SuccessRegistActivity
import com.indev.geeknewsapps.register.UserProfilingActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.dialog_forget_password.*

class LoginActivity : AppCompatActivity() {

    companion object {
        private const val RC_SIGN_IN = 120
    }

    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        tv_forgetPassword.setOnClickListener {
            resetPassword()
        }

        btn_login.setOnClickListener {
            signInWithEmail()
        }

        btn_gmail.setOnClickListener {
            signInWithGoogle()
        }

        tv_regist.setOnClickListener {
            val btnRegist = Intent(this, RegisterActivity::class.java)
            startActivity(btnRegist)
        }
    }

    private fun resetPassword() {
        val resetPassword = Dialog(this)

        resetPassword.setContentView(R.layout.dialog_forget_password)
        resetPassword.btn_submit.setOnClickListener {
            val email = resetPassword.et_emailResetPass.text.toString().trim()

            if (email.isEmpty()) {
                resetPassword.et_emailResetPass.error = "Please enter email address"
                resetPassword.et_emailResetPass.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                resetPassword.et_emailResetPass.error = "Invalid email!"
                resetPassword.et_emailResetPass.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(
                            applicationContext,
                            "Check email for link reset password",
                            Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
            resetPassword.dismiss()
        }

        resetPassword.setCancelable(true)
        resetPassword.show()
    }

    private fun signInWithEmail() {
        val email = et_emailAddress.text.toString().trim()
        val password = et_password.text.toString().trim()

        if (email.isEmpty()) {
            et_emailAddress.error = "Please enter email address"
            et_emailAddress.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_emailAddress.error = "Invalid email!"
            et_emailAddress.requestFocus()
            return
        }

        if (password.isEmpty()) {
            et_password.error = "Please enter password"
            et_password.requestFocus()
            return
        }

        signInUser(email, password)
    }

    private fun signInUser(email: String, password: String) {
        val progressBar = Dialog(this)
        progressBar.setContentView(R.layout.dialog_progressbar)
        progressBar.show()

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        val successIntent = Intent(this, SuccessRegistActivity::class.java)
                        startActivity(successIntent)
                        finish()
                    } else {
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
//                        Log.w("LoginActivity", "Google sign in failed")
                    }

                    progressBar.setCancelable(false)
                    progressBar.dismiss()
                }
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val exception = task.exception
            if (task.isSuccessful) {
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d("LoginActivity", "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    // Google Sign In failed, update UI appropriately
                    Log.w("LoginActivity", "Google sign in failed", e)
                }
            } else {
                Log.w("LoginActivity", exception.toString())
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val progressBar = Dialog(this)
        progressBar.setContentView(R.layout.dialog_progressbar)
        progressBar.show()

        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("LoginActivity", "signInWithCredential:success")
                        val profillingIntent = Intent(this, UserProfilingActivity::class.java)
                        startActivity(profillingIntent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("LoginActivity", "signInWithCredential:failure", task.exception)
                    }

                    progressBar.setCancelable(false)
                    progressBar.dismiss()
                }
    }
}