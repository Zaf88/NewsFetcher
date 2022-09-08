package com.example.newsfetcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.newsfetcher.feature.mainscreen.MainScreenFragment
import com.example.newsfetcher.feature.mainscreen.bookmarks.ui.BookmarksFragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val bottomNavigationView: BottomNavigationView by lazy { findViewById(R.id.bnvBar) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, MainScreenFragment())
            .commit()

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemMain -> {
                    selectTab(MainScreenFragment())
                }
                R.id.itemBookmarks -> {
                    selectTab(BookmarksFragment())
                }
                else -> {}
            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.itemMain
    }

    private fun selectTab(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment)
            .commit()
    }

    private fun removeTab (fragment: Fragment) {
        supportFragmentManager.beginTransaction().remove(fragment).commit()

}}