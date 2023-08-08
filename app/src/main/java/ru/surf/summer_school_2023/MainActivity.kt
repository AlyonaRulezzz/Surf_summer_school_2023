package ru.surf.summer_school_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_no_coctails.view.*
import ru.surf.summer_school_2023.databinding.ActivityMainBinding
import ru.surf.summer_school_2023.model.CocktailModel
import viewmodel.ViewmodelRecyclerviewFragment

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    private val fragmentRV = ViewmodelRecyclerviewFragment()
    private var findedFragmentRV = findFragmentRV(fragmentRV)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToFragment(NoCoctailsFragment())

        if (findedFragmentRV?.loadListFromSharedPreferences(this, "listOfCocktailModel")?.size == null) {
            goToFragment(NoCoctailsFragment())
//            binding.fragmentNoCoctails.addCocktailButton.setOnClickListener {
    //            add new cocktail fragment
//            }
        } else {
            goToFragment(fragmentRV)
        }
    }

    private fun goToFragment(fragment: Fragment) {
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentNoCoctails, fragment).commit()
    }

    private fun findFragmentRV(fragment: Fragment): ViewmodelRecyclerviewFragment? {
        fragmentManager = supportFragmentManager
        return fragmentManager.findFragmentById(fragment.id) as ViewmodelRecyclerviewFragment?
    }
}