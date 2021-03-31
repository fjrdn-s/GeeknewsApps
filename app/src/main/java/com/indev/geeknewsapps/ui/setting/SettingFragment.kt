package com.indev.geeknewsapps.ui.setting

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.login.LoginActivity
import com.indev.geeknewsapps.ui.setting.help.HelpSettingActivity
import com.indev.geeknewsapps.ui.setting.profile.ProfileSettingActivity
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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
                tv_fullName.text = currentUser.uid
            }
        }

        tv_emailUser.text = currentUser?.email

//        (activity as SettingActivity)
//
//        btn_profileSetting.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_settingFragment_to_profileSettingFragment)
//        }
//
//        btn_helpSetting.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_settingFragment_to_helpSettingFragment)
//        }


        btn_profileSetting.setOnClickListener {
            val btnProfile = Intent(activity, ProfileSettingActivity::class.java)
            startActivity(btnProfile)
        }

        btn_helpSetting.setOnClickListener {
            val btnHelp = Intent(activity, HelpSettingActivity::class.java)
            startActivity(btnHelp)
        }

        btn_logout.setOnClickListener {
            alertLogout()
        }
    }

    private fun alertLogout() {
        val builder = activity?.let {
            AlertDialog.Builder(it)
        }

        builder?.setTitle("Logout?")
        builder?.setMessage("Are you sure?")
        builder?.setIcon(R.drawable.ic_warning)

        builder?.setPositiveButton("Yes") { dialog, _ ->
            mAuth.signOut()
            val btnLogout = Intent(activity, LoginActivity::class.java)
            startActivity(btnLogout)
            activity?.let { it1 -> finishAffinity(it1) }
            dialog.dismiss()
        }

        builder?.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }

        val alertDialog = builder?.create()

        alertDialog?.setCancelable(false)
        alertDialog?.show()
    }
}