package com.indev.geeknewsapps.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.ui.home._model.HomeHorizontal
import com.indev.geeknewsapps.ui.home._model.HomeHorizontalData
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var horizontalList: ArrayList<HomeHorizontal> = arrayListOf()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rc_listHorizontal.setHasFixedSize(true)

        horizontalList.addAll(HomeHorizontalData.listData)
        showRecyclerList()

        val sectionsPagerAdapter= SectionsPagerAdapter(
            childFragmentManager
        )
        vp_Home.adapter= sectionsPagerAdapter
        tab_LayoutHome.setupWithViewPager(vp_Home)

    }

    private fun showRecyclerList() {
        rc_listHorizontal.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val homeHorizontalAdapter = HomeHorizontalAdapter(horizontalList)
        rc_listHorizontal.adapter = homeHorizontalAdapter
    }
}