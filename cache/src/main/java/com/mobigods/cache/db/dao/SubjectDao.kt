package com.mobigods.cache.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobigods.cache.models.SubjectCacheModel

@Dao
abstract class SubjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun saveSubjects(subjects: List<SubjectCacheModel>): List<Long>

    @Query("SELECT * FROM subjects")
    abstract fun getAllSubjects(): List<SubjectCacheModel>

}