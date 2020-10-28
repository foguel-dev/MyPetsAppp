package com.example.mypets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mypets.fragments.CalendarFragment
import com.example.mypets.fragments.HomeFragment
import com.example.mypets.fragments.PetsFragment
import com.example.mypets.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val calendarFragment = CalendarFragment()
        val petsFragment = PetsFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_search -> makeCurrentFragment(searchFragment)
                R.id.ic_time -> makeCurrentFragment(calendarFragment)
                R.id.ic_pets -> makeCurrentFragment(petsFragment)
            }
            true
        }


        //Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show()
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
}