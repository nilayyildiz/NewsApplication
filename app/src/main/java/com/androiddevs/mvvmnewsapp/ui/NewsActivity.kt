package com.androiddevs.mvvmnewsapp.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.repository.NewsRepository
import com.androiddevs.mvvmnewsapp.ui.fragments.ArticleFragment
import com.androiddevs.mvvmnewsapp.ui.fragments.BreakingNewsFragment
import com.androiddevs.mvvmnewsapp.ui.fragments.SavedNewsFragment
import com.androiddevs.mvvmnewsapp.ui.fragments.SearchNewsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.flFragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        bottomNav.setupWithNavController(navHostFragment.navController)



    }

}
