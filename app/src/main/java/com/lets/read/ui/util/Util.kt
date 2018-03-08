package com.lets.read.ui.util

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author Mateus Andrade
 * @since 07/03/2018
 */

class Util{

    fun setImageUrl(imageView: ImageView, url: String) {
        val context = imageView.getContext()
        Glide.with(context).load(url).into(imageView);
        //Picasso.with(context).load(url).fit().centerInside().error(R.drawable.no_image).placeholder(R.drawable.no_image).into(imageView);
    }
}