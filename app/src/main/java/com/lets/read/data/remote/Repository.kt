package com.lets.read.data.remote

import com.lets.read.data.model.Item
/**
 * @author Mateus Andrade
 * @since 07/03/2018
 */

class Repository constructor(val api: BookApi ) {

    fun doSearchSync(q: String): List<Item>? {
        var response = api.getBooks(q).execute()
        if(response.isSuccessful)
            return response.body()?.items
        else
            return null
    }
}