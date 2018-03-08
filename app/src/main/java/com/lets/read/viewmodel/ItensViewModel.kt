package com.lets.read.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.lets.read.data.model.Item
import com.lets.read.data.remote.BookApi
import com.lets.read.data.remote.Repository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async

/**
 * @author Mateus Andrade
 * @since 06/03/2018
 */

class ItensViewModel : ViewModel() {

    var items = MutableLiveData<List<Item>>()
    var bookApi =  BookApi.create()
    var repository = Repository(bookApi)

    suspend fun getNewListOfBooks(q : String) {
        items.value = async(CommonPool) { repository.doSearchSync(q) }.await()
    }
}