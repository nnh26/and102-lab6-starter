package com.codepath.lab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.codepath.lab6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Define fragments
        val parksFragment: Fragment = ParksFragment()
        val campgroundFragment: Fragment = CampgroundFragment()

        // Handle navigation item selection
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.action_parks -> parksFragment
                R.id.action_campgrounds -> campgroundFragment
                else -> parksFragment
            }
            replaceFragment(fragment)
            true
        }

        // Set default selection
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.action_parks
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
