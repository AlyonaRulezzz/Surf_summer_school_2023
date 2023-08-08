package viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.surf.summer_school_2023.model.CocktailModel
import java.util.*
import kotlin.collections.ArrayList

class ViewmodelRecyclerviewViewModel(l: List<CocktailModel>) : ViewModel() {

    val _liveDataList = MutableLiveData<List<CocktailModel>>(if (l.isNotEmpty()) l else myNumber())

    val liveDataList: LiveData<List<CocktailModel>> get() = _liveDataList

    private val deletedPool: Queue<Int> = LinkedList()

    init {
        addItem(_liveDataList.value?.last()?.name?.plus(1)!!)
    }

    fun deleteItem(number: Int) {
        viewModelScope.launch {
            deletedPool.add(number)
        }
        val list = _liveDataList.value?.filter { it.name != number } ?: error("") //TODO
        _liveDataList.value = list
    }

    fun myNumber(): ArrayList<CocktailModel>{
        val numberList = ArrayList<CocktailModel>()

        lateinit var number: CocktailModel
        for (i in 1..15) {
            number = CocktailModel(i)
            numberList.add(number)
        }

        return numberList
    }

    fun addItem(nextNumber: Int) {
        var i = nextNumber
        Log.d("MY_LOG_addItem", nextNumber.toString())
        viewModelScope.launch {
            while (true) {
                delay(2_000)
                val list = _liveDataList.value?.toMutableList() ?: error("") //TODO
                if (deletedPool.isEmpty()) {
                    list.add(CocktailModel(i))
                    i++
                } else {
                    list.add(CocktailModel(deletedPool.remove()))
                }
                _liveDataList.value = list
            }
        }
    }
}