package com.indev.geeknewsapps.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.indev.geeknewsapps.R
import com.indev.geeknewsapps.login.LoginActivity
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    private val onboardingSliderAdapter= OnboardingSliderAdapter(
        listOf(
            OnboardingSlider(
                "Trusted",
                "is simply dummy text of the printing and typesetting industry.",
                R.drawable.ob1
            ),
            OnboardingSlider(
                "Update",
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                R.drawable.ob2
            ),
            OnboardingSlider(
                "Content",
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                R.drawable.ob3
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        vp_slider.adapter= onboardingSliderAdapter
        SetupIndicators()
        setCurrentIndicator(0)
        vp_slider.registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        btn_next.setOnClickListener {
            if (vp_slider.currentItem + 1 < onboardingSliderAdapter.itemCount) {
                vp_slider.currentItem += 1
            } else {
                Intent(applicationContext, LoginActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        tv_skipIntro.setOnClickListener {
            Intent(applicationContext, LoginActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val indicatorContainer = findViewById<LinearLayout>(R.id.indicatorContainer)

        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }

    }

    private fun SetupIndicators() {
        val indicators = arrayOfNulls<ImageView>(onboardingSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }

            val indicatorContainer = findViewById<LinearLayout>(R.id.indicatorContainer)
            indicatorContainer.addView(indicators[i])
        }
    }
}