package com.lets.read.data.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.google.gson.annotations.SerializedName
//import com.lets.read.BR

/**
 * @author Mateus Andrade
 * @since 06/03/2018
 */

data class Book (
    @SerializedName("title") var title: String = "",
    @SerializedName("publisher") var publisher: String = "",
    @SerializedName("pageCount") var pageCount: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("imageLinks") var imageLinks: ImageLinks
)

