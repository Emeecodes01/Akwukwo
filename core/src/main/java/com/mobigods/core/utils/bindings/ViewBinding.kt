package com.mobigods.core.utils.bindings

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.card.MaterialCardView
import com.mobigods.core.utils.Tools

@BindingAdapter("subjectName")
fun setSubjectIcons(view: ImageView, subject: String) {
    view.setImageResource(Tools.getSubjectIconFromName(subject))
}


@BindingAdapter("subject")
fun setSubjectBackground(view: ImageView, subject: String) {
    view.setImageResource(Tools.getSubjectBackgroundFromName(subject))
}


@BindingAdapter("subjectName")
fun setSubjectImageBackground(view: MaterialCardView, subject: String) {
    val colorInt = ContextCompat.getColor(view.context, Tools.getCardColorFromName(subject))
    view.setCardBackgroundColor(colorInt)
}
