package com.mobigods.core.utils.layoutmanagers

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager


class AnimatedLinearLayoutManager(context: Context): LinearLayoutManager(context) {

    override fun supportsPredictiveItemAnimations(): Boolean {
        return false
    }
}