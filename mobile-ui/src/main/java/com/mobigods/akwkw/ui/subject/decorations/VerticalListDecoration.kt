package com.mobigods.akwkw.ui.subject.decorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalListDecoration(private val spacing: Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            top = spacing / 4
            bottom = spacing / 4
            right = spacing /2
            left = spacing/2
        }
    }
}