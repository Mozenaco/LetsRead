package com.lets.read.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Mateus Andrade
 * @since 07/03/2018
 */

data class Item(
    @SerializedName("volumeInfo") val volumeInfo: Book
)