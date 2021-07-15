package com.learn.allaboutcoroutines.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learn.allaboutcoroutines.data.model.Cat
import kotlinx.android.synthetic.main.list_item_cat.view.*

class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(cat: Cat) {
        Glide.with(itemView.context)
            .load(cat.url)
            .centerCrop()
            .thumbnail()
            .into(itemView.ivCat)
    }
}