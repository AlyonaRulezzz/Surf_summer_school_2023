package ru.surf.summer_school_2023.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_number_layout.view.*
import ru.surf.summer_school_2023.R
import ru.surf.summer_school_2023.databinding.ItemNumberLayoutBinding
import ru.surf.summer_school_2023.model.CocktailModel


class NumberAdapter(
    val listener: (value: Int) -> Unit,
): RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {


    private var numberList = emptyList<CocktailModel>()

    private var i = 0

    inner class NumberViewHolder(val binding: ItemNumberLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(value: CocktailModel) {
            itemView.tv_number.text = value.name.toString()
            val res = ContextCompat.getDrawable(context, R.drawable.ic_baseline_delete_24)
            itemView.iv_cancel.setImageDrawable(res)
            itemView.iv_cancel.setOnClickListener {
                listener(value.name)
                notifyItemRemoved(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_number_layout, parent, false)
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNumberLayoutBinding.inflate(inflater, parent, false)
        return NumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val item = numberList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CocktailModel>) {
        numberList = list
        notifyDataSetChanged()
    }
}
