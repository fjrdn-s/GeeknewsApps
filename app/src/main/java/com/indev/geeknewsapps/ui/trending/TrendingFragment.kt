package com.indev.geeknewsapps.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.ui._model.ModelData
import com.indev.geeknewsapps.ui.home.HomeHorizontalAdapter
import com.indev.geeknewsapps.ui.home._objek.HomeHorizontalData
import com.indev.geeknewsapps.ui.trending.adapter.TrendingVerticalAdapter
import kotlinx.android.synthetic.main.fragment_home.rc_listHorizontal
import kotlinx.android.synthetic.main.fragment_trending.*

class TrendingFragment : Fragment() {

    private var verticalList: ArrayList<ModelData> = arrayListOf()
    private var horizontalList: ArrayList<ModelData> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trending, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rc_listHorizontal.setHasFixedSize(true)
        rc_TrendVertical.setHasFixedSize(true)

        horizontalList.addAll(HomeHorizontalData.listData)
        verticalList.addAll(HomeHorizontalData.listData)
        showRecyclerHorizontal()
        showRecyclerVertical()
    }

    private fun showRecyclerVertical() {
        rc_TrendVertical.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val trendingVerticalAdapter = TrendingVerticalAdapter(verticalList)
        rc_TrendVertical.adapter = trendingVerticalAdapter
    }

    private fun showRecyclerHorizontal() {
        rc_listHorizontal.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val homeHorizontalAdapter = HomeHorizontalAdapter(horizontalList)
        rc_listHorizontal.adapter = homeHorizontalAdapter
    }
}