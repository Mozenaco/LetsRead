package com.lets.read.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.lets.read.R
import com.lets.read.ui.adapter.BooksListAdapter
import com.lets.read.viewmodel.ItensViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    private val booksListAdapter by lazy {
        BooksListAdapter(this)
    }

    lateinit var model : ItensViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = booksListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        model = ViewModelProviders.of(this).get(ItensViewModel::class.java)
        model.items.observe(this, Observer { items ->
            items?.also {
                booksListAdapter.bookList.clear()
                booksListAdapter.bookList.addAll(it)
                booksListAdapter.notifyDataSetChanged()
            }
        })

        searchField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(search: CharSequence?, start: Int, before: Int, count: Int) {
                if(count > 0) {
                    launch(UI) {
                        Log.d("MainActivity", "realizando pesquisa realizada com nome do livro: " + search.toString())

                        model.getNewListOfBooks(search.toString())
                    }

                    Log.d("MainActivity", "apos launch")
                }
            }
        })
    }
}
