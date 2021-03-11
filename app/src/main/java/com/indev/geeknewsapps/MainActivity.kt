package com.indev.geeknewsapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_trending,
                R.id.navigation_category,
                R.id.navigation_search,
                R.id.navigation_setting
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navView, navController)
    }
}