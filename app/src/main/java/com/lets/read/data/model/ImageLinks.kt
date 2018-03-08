package com.lets.read.data.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.google.gson.annotations.SerializedName

/**
 * @author Mateus Andrade
 * @since 06/03/2018
 */

data class ImageLinks (
    @SerializedName("smallThumbnail") var smallThumbnail: String = ""
)