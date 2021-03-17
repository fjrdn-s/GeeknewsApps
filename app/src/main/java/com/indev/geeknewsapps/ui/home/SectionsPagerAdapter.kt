package com.indev.geeknewsapps.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.indev.geeknewsapps.ui.home.event.HomeEventFragment
import com.indev.geeknewsapps.ui.home.game.HomeGameFragment
import com.indev.geeknewsapps.ui.home.movie.HomeMovieFragment
import com.indev.geeknewsapps.ui.home.tekno.HomeTechFragment

@Suppress("DEPRECATION")
class SectionsPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> HomeTechFragment()
            1 -> HomeGameFragment()
            2 -> HomeMovieFragment()
            3 -> HomeEventFragment()
            else ->
                return HomeTechFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Tech"
            1 -> "Games"
            2 -> "Movie"
            3 -> "Event"
            else ->
                return ""
        }
    }
}