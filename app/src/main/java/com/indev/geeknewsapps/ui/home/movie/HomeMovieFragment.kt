package com.indev.geeknewsapps.ui.home.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.ui._model.ModelData
import com.indev.geeknewsapps.ui.category.movie.CategoryMovieData
import com.indev.geeknewsapps.ui.category.movie.MovieVerticalAdapter
import kotlinx.android.synthetic.main.fragment_home_movie.*

class HomeMovieFragment : Fragment() {

    private var movieVertical: ArrayList<ModelData> = arrayListOf()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rc_ListVertical.setHasFixedSize(true)

        movieVertical.addAll(CategoryMovieData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rc_ListVertical.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val movieVerticalAdapter = MovieVerticalAdapter(movieVertical)
        rc_ListVertical.adapter = movieVerticalAdapter
    }
}