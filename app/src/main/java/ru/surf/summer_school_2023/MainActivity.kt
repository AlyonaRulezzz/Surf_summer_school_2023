package ru.surf.summer_school_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.surf.summer_school_2023.databinding.ActivityMainBinding
import viewmodel.ViewmodelRecyclerviewFragment

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    private var cocktailListForFragment = ViewmodelRecyclerviewFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        if (cocktailListForFragment.loadListFromSharedPreferences(this, "listOfCocktailModel") == emptyList())
//        goToFragment(NoCoctailsFragment())
        goToFragment(cocktailListForFragment)
    }

    private fun goToFragment(fragment: Fragment) {
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentNoCoctails, fragment).commit()
    }
}