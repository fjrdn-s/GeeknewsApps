package com.indev.geeknewsapps.ui.home.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.ui._model.ModelData
import com.indev.geeknewsapps.ui.category.event.CategoryEventData
import com.indev.geeknewsapps.ui.category.event.EventVerticalAdapter
import kotlinx.android.synthetic.main.fragment_home_event.*

class HomeEventFragment : Fragment() {

    private var eventVertical: ArrayList<ModelData> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_event, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rc_ListVertical.setHasFixedSize(true)

        eventVertical.addAll(CategoryEventData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rc_ListVertical.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val eventVerticalAdapter = EventVerticalAdapter(eventVertical)
        rc_ListVertical.adapter = eventVerticalAdapter
    }
}