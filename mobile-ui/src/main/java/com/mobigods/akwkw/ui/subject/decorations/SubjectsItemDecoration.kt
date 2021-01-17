package com.mobigods.akwkw.ui.subject.decorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SubjectsItemDecoration(private val spacing: Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            top = spacing/2
            bottom = spacing/2
        }
        val position = parent.getChildAdapterPosition(view)
        when {
            position % 2 != 0 -> {
                //left childviews
                with(outRect) {
                    left = spacing/2
                    right = spacing
                }
            }
            else -> {
                with(outRect) {
                    right = spacing/2
                    left = spacing
                }
            }
        }
    }
}