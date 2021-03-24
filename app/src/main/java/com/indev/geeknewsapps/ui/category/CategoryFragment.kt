package com.indev.geeknewsapps.ui.category

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.ui.category.event.CategoryEventActivity
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ib_event.setOnClickListener {
            val mvEvent = Intent(activity, CategoryEventActivity::class.java)
            startActivity(mvEvent)
        }
    }
}