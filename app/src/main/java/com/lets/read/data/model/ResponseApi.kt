package com.lets.read.data.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName

/**
 * @author Mateus Andrade
 * @since 06/03/2018
 */

data class ResponseApi (
    @SerializedName("kind") var kind: String = "",
    @SerializedName("items") val items: List<Item>
)