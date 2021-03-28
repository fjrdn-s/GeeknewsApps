package com.indev.geeknewsapps.register

import android.annotation.SuppressLint
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

//    companion object {
//        const val REQUEST_CAMERA = 100
//    }
//
//    private lateinit var imageUri: Uri
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

//        iv_profile.setOnClickListener {
//            requestCamera()
//        }

        btn_regist.setOnClickListener {
            requestRegist()
        }
    }

//    private fun requestCamera() {
//        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
//            this.packageManager?.let {
//                intent.resolveActivity(it).also {
//                    startActivityForResult(intent, REQUEST_CAMERA)
//                }
//            }
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
//            val imgBitmap = data?.extras?.get("data") as Bitmap
//            uploadImage(imgBitmap)
//        }
//    }
//
//    private fun uploadImage(imgBitmap: Bitmap) {
//        val baos = ByteArrayOutputStream()
//        val reference = FirebaseStorage.getInstance()
//                .reference
//            .child("img/")
////                .child("img/${FirebaseAuth.getInstance().currentUser?.uid}")
//
//        imgBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
//        val image = baos.toByteArray()
//
//        reference.putBytes(image)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        reference.downloadUrl.addOnCompleteListener { Uri ->
//                            Uri.result?.let {
//                                imageUri = it
//                                iv_profile.setImageBitmap(imgBitmap)
//                            }
//                        }
//                    }
//                }
//    }

    private fun requestRegist() {
        val fullName = et_fullName.text.toString().trim()
        val email = et_emailAddress.text.toString().trim()
        val password = et_password.text.toString().trim()

        if (fullName.isEmpty()) {
            et_fullName.error = "Please enter full name!"
            et_fullName.requestFocus()
            return
        }

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

        registerUser(email, password)
    }

    private fun registerUser(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        val profillingIntent = Intent(this, UserProfilingActivity::class.java)
                        startActivity(profillingIntent)
                        finish()
                    } else {
                        Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
    }
}