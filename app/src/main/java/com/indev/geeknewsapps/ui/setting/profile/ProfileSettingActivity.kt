package com.indev.geeknewsapps.ui.setting.profile

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.storage.FirebaseStorage
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.register.SuccessRegistActivity
import kotlinx.android.synthetic.main.activity_profile_setting.*
import java.io.ByteArrayOutputStream

class ProfileSettingActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CAMERA = 100
    }

    private lateinit var imageUri: Uri
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_setting)

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

        iv_back.setOnClickListener {
            onBackPressed()
        }

        iv_addPhoto.setOnClickListener {
            requestCamera()
        }

        btn_save.setOnClickListener {
            val image = when {
                ::imageUri.isInitialized -> imageUri
                currentUser?.photoUrl == null -> Uri.parse("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1200px-No_image_available.svg.png")
                else -> currentUser.photoUrl
            }

            val name = et_fullName.text.toString().trim()

            if (name.isEmpty()) {
                et_fullName.error = "Enter full name!"
                et_fullName.requestFocus()
                return@setOnClickListener
            }

            UserProfileChangeRequest.Builder()
                    .setDisplayName(name)
                    .setPhotoUri(image)
                    .build().also { it ->
                        currentUser?.updateProfile(it)?.addOnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(this, "Profile updated :)", Toast.LENGTH_SHORT).show()

                                val settingIntent = Intent(this, SuccessRegistActivity::class.java)
                                startActivity(settingIntent)
                                finish()
                            } else {
                                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
        }
    }

    private fun requestCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            this.packageManager?.let {
                intent.resolveActivity(it).also {
                    startActivityForResult(intent, REQUEST_CAMERA)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            val imgBitmap = data?.extras?.get("data") as Bitmap
            uploadImage(imgBitmap)
        }
    }

    private fun uploadImage(imgBitmap: Bitmap) {
        val baos = ByteArrayOutputStream()
        val reference = FirebaseStorage.getInstance()
                .reference
                .child("img/")
                .child("img/${FirebaseAuth.getInstance().currentUser?.uid}")

        imgBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val image = baos.toByteArray()

        reference.putBytes(image)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        reference.downloadUrl.addOnCompleteListener { Uri ->
                            Uri.result?.let {
                                imageUri = it
                                iv_profile.setImageBitmap(imgBitmap)
                            }
                        }
                    }
                }
    }
}