package com.indev.geeknewsapps.ui.home.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.ui.home._model.HomeHorizontal
import com.indev.geeknewsapps.ui.home._model.HomeHorizontalData
import kotlinx.android.synthetic.main.fragment_home_game.*

class HomeGameFragment : Fragment() {

    private var gameVertical: ArrayList<HomeHorizontal> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_game, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rc_ListVertical.setHasFixedSize(true)

        gameVertical.addAll(HomeHorizontalData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rc_ListVertical.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val gameVerticalAdapter = GameVerticalAdapter(gameVertical)
        rc_ListVertical.adapter = gameVerticalAdapter
    }
}