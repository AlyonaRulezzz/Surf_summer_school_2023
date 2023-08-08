package ru.surf.summer_school_2023
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.surf.summer_school_2023.databinding.FragmentNoCoctailsBinding
import viewmodel.ViewmodelRecyclerviewFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NoCoctailsFragment : Fragment() {
    private lateinit var binding: FragmentNoCoctailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_no_coctails, container, false)
        binding = FragmentNoCoctailsBinding.bind(rootView)

        // Inflate the layout for this fragment
        return rootView
    }
}