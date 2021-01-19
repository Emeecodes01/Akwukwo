package com.mobigods.cache.models

import androidx.room.Embedded
import androidx.room.Relation

data class RecentLessonWithSubjectCacheModel(
    @Embedded
    val recentLessonCacheModel: RecentLessonCacheModel,
    @Relation(
        parentColumn = "subject_id",
        entityColumn = "id"
    )
    val subjectCacheModel: SubjectCacheModel
)
