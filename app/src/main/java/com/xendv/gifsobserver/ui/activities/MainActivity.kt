package com.xendv.gifsobserver.ui.activities

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.xendv.gifsobserver.R
import com.xendv.gifsobserver.databinding.ActivityMainBinding
import com.xendv.gifsobserver.mvp.presenter.MainPresenter
import com.xendv.gifsobserver.mvp.view.MainView
import com.xendv.gifsobserver.ui.activities.ui.main.SectionsPagerAdapter
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

        val prevButton = binding.bottomNavButtons.backBotton
        prevButton.isEnabled = false
        val nextButton = binding.bottomNavButtons.nextButton

        prevButton.setOnClickListener { getPreviousPost() }
        nextButton.setOnClickListener { getNextPost() }

        getPost()
    }

    override fun updateView() {
        Glide.with(this)
            .load(mainPresenter.mPostsDao.tempPost?.post?.gifURL)
            .into(findViewById(R.id.gif_image))
        val description:TextView = findViewById(R.id.info_text)
        description.text = mainPresenter.mPostsDao.tempPost?.post?.description
    }

    override fun showProgress(show: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getPreviousPost() {
        val post = mainPresenter.mPostsDao.getPrevSavedPost()
        if (post != null) {
            updateView()
        }
        else {
            val prevButton = binding.bottomNavButtons.backBotton
            prevButton.isEnabled = false
        }
    }

    fun getPost(){
        val post = mainPresenter.mPostsDao.getNextSavedPost()
        if (post == null) {
            mainPresenter.loadNewPost()
        }
        else updateView()
    }

    override fun getNextPost() {
        val post = mainPresenter.mPostsDao.getNextSavedPost()
        if (post == null) {
            mainPresenter.loadNewPost()
            val prevButton = binding.bottomNavButtons.backBotton
            prevButton.isEnabled = true
        }
    }

    override fun showErrorMessage(localizedMessage: String?) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show()
    }
}