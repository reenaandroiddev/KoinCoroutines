package com.learn.allaboutcoroutines.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learn.allaboutcoroutines.R
import com.learn.allaboutcoroutines.data.model.Cat
import kotlin.properties.Delegates

class CatAdapter() : RecyclerView.Adapter<CatViewHolder>() {

    // Our data list is going to be notified when we assign a new list of data to it
    private var catsList: List<Cat> by Delegates.observable(emptyList())
    { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_cat, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(cat = catsList[position])
    }

    override fun getItemCount(): Int = catsList.size

    fun updateData(newCatsList: List<Cat>) {
        catsList = newCatsList
    }
}