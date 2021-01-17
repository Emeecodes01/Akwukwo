package com.mobigods.core.utils.layoutmanagers

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class AnimatedHorizontalLinearLayoutManager(context: Context): LinearLayoutManager(context, HORIZONTAL, false){

    override fun supportsPredictiveItemAnimations(): Boolean {
        return false
    }
}