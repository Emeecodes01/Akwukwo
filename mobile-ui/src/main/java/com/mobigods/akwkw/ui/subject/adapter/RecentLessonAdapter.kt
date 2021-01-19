package com.mobigods.akwkw.ui.subject.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mobigods.akwkw.databinding.LayoutLessonItemBinding
import com.mobigods.akwkw.databinding.LayoutRecentItemBinding
import com.mobigods.core.utils.Tools
import com.mobigods.core.utils.extensions.checkAndUpdateItems
import com.mobigods.core.utils.extensions.click
import com.mobigods.domain.models.RecentLesson
import com.mobigods.presentation.models.RecentLessonModel
import com.mobigods.presentation.models.SubjectModel
import kotlin.properties.Delegates

class RecentLessonAdapter(private val subjectName: (Int) -> String?,
                          private val onClicked: (RecentLessonModel) -> Unit): RecyclerView.Adapter<RecentLessonAdapter.RecentLessonViewHolder>(){

    private lateinit var binding: LayoutRecentItemBinding
    private lateinit var context: Context

    var recents: List<RecentLessonModel> by Delegates.observable(emptyList()) { _, oldList, newList ->
        checkAndUpdateItems(oldList, newList) { old, new ->
            old.id == new.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentLessonViewHolder {
        context = parent.context
        binding = LayoutRecentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentLessonViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecentLessonViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount() = recents.size

    inner class RecentLessonViewHolder(view: View): RecyclerView.ViewHolder(view) {

        init {
            binding.lessonsCard.click {
                onClicked.invoke(recents[adapterPosition])
            }
        }

        fun bindView(position: Int) {
            val recentLesson = recents[position]
            val subName = subjectName(recentLesson.lesson.subject_id) ?: ""
            binding.recentLesson = recentLesson
            binding.subjectName.text = subName
            val subjectColorRes = Tools.getCardColorFromName(subName)
            val colorInt = ContextCompat.getColor(context, subjectColorRes)
            binding.subjectName.setTextColor(colorInt)
            binding.imageView5.imageTintList = ColorStateList.valueOf(colorInt)
        }

    }
}