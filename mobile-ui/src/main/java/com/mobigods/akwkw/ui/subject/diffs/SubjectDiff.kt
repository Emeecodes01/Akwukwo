package com.mobigods.akwkw.ui.subject.diffs

import com.mobigods.core.base.BaseDiffUtil
import com.mobigods.presentation.models.SubjectModel

class SubjectDiff(oldList: List<SubjectModel>, newList: List<SubjectModel>): BaseDiffUtil<SubjectModel>(oldList, newList) {

    override fun isItemTheSame(oldItem: SubjectModel, newItem: SubjectModel): Boolean {
        return oldItem.id == newItem.id
    }

}