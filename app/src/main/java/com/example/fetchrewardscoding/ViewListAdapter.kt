package com.example.fetchrewardscoding

import android.graphics.Color
import android.graphics.drawable.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardscoding.model.HiringModel

class ViewListAdapter():
    RecyclerView.Adapter<ViewListAdapter.RowViewHolder>() {

    private val whiteBackground: LayerDrawable = arrayOf(
            ColorDrawable(Color.LTGRAY),
            ColorDrawable(Color.WHITE)).let {
        LayerDrawable(it).apply {
            setLayerInset(0, 0, 15, 0, 0)
            setLayerInset(1, 0, 0, 0, 15)
        }
    }

    private val cyanBackground: LayerDrawable = arrayOf(
            ColorDrawable(Color.LTGRAY),
            ColorDrawable(Color.CYAN)).let {
        LayerDrawable(it).apply {
            setLayerInset(0, 0, 15, 0, 0)
            setLayerInset(1, 0, 0, 0, 15)
        }
    }

    var dataSet = listOf<HiringModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class RowViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val listIdTextView: TextView
        val nameTextView: TextView
        val parentLayout: View

        init {
            listIdTextView = view.findViewById(R.id.tv_listId)
            nameTextView = view.findViewById(R.id.tv_name)
            parentLayout = view
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hiring_list_row, parent, false)
        return RowViewHolder(view)
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        if(position % 2 == 0) {
            holder.parentLayout.background = whiteBackground
        } else {
            holder.parentLayout.background = cyanBackground
        }
        holder.listIdTextView.text = dataSet[position].listId.toString()
        holder.nameTextView.text = dataSet[position].name
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}