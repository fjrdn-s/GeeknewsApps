package com.indev.geeknewsapps.ui.setting

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.ui.setting.help.HelpSettingActivity
import com.indev.geeknewsapps.ui.setting.profile.ProfileSettingActivity
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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
            val btnProfile= Intent(activity, ProfileSettingActivity::class.java)
            startActivity(btnProfile)
        }

        btn_helpSetting.setOnClickListener {
            val btnHelp= Intent(activity, HelpSettingActivity::class.java)
            startActivity(btnHelp)

//            Toast.makeText(context, "test click Help and other", Toast.LENGTH_SHORT).show()
        }
    }
}