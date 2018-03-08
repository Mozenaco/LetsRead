package com.lets.read.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.lets.read.R
import com.lets.read.data.model.Book
import com.lets.read.data.model.Item
import kotlinx.android.synthetic.main.book_item.view.*

/**
 * @author Mateus Andrade
 * @since 07/03/2018
 */

class BooksListAdapter(
        private val context: Context,
        var bookList: ArrayList<Item> = arrayListOf<Item>()): RecyclerView.Adapter<BooksListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bookList?.also { items -> holder.bindItem(items[position].volumeInfo) }
    }

    override fun getItemCount(): Int = bookList?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val feedItemView = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false)
        return ViewHolder(feedItemView)
    }

    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bindItem(item: Book) {

            if(item.imageLinks != null && !item.imageLinks.smallThumbnail.isNullOrEmpty())
                Glide.with(context).load(item.imageLinks.smallThumbnail).into(itemView.image)
            itemView.title.text = getValue(item.title)
            itemView.publisher.text = getValue(item.publisher)
            itemView.pageCount.text = getValue( item.pageCount)
            itemView.description.text = getValue( item.description)
        }
    }

    fun getValue(value : String?): String = if(value.isNullOrEmpty()) "-" else value!!

}