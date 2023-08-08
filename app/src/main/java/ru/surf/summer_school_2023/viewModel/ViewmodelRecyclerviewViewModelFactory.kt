package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.surf.summer_school_2023.model.CocktailModel

class ViewmodelRecyclerviewViewModelFactory: ViewModelProvider.Factory {
    private var mParam: List<CocktailModel>? = null

    constructor(l: List<CocktailModel>) {
        mParam = l
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewmodelRecyclerviewViewModel::class.java)) {
            ViewmodelRecyclerviewViewModel(mParam!!) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}