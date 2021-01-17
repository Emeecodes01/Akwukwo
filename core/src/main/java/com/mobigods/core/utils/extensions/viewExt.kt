package com.mobigods.core.utils.extensions

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mobigods.core.base.BaseDiffUtil

fun View.click(action: () -> Unit) {
    setOnClickListener {
        action.invoke()
    }
}


fun <T> RecyclerView.Adapter<*>.checkAndUpdateItems(oldList: List<T>, newList: List<T>, compareItems: (T, T) -> Boolean) {
    val diffUtilCallbackImpl = object: BaseDiffUtil<T>(oldList, newList){
        override fun isItemTheSame(oldItem: T, newItem: T): Boolean {
            return compareItems.invoke(newItem, oldItem)
        }

    }

    val diff = DiffUtil.calculateDiff(diffUtilCallbackImpl)
    diff.dispatchUpdatesTo(this)
}