package com.mobigods.akwkw.ui.chapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobigods.akwkw.databinding.LayoutLessonItemBinding
import com.mobigods.core.utils.extensions.checkAndUpdateItems
import com.mobigods.core.utils.extensions.click
import com.mobigods.core.utils.image.ImageLoader
import com.mobigods.presentation.models.LessonModel
import kotlin.properties.Delegates

class LessonAdapter(private val imageLoader: ImageLoader,
                    private val onLessonClicked: (LessonModel) -> Unit): RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private lateinit var binding: LayoutLessonItemBinding

    var lessons: List<LessonModel> by Delegates.observable(emptyList()) { _, oldList, newList ->
        checkAndUpdateItems(oldList, newList) { old, new ->
            old.id == new.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        binding = LayoutLessonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(binding.root)
    }


    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount(): Int  = lessons.size


    inner class LessonViewHolder(view: View): RecyclerView.ViewHolder(view) {

        init {
            binding.lessonsCard.click {
                onLessonClicked.invoke(lessons[adapterPosition])
            }
        }

        fun bindView(position: Int) {
            binding.lesson = lessons[position]
            imageLoader.loadImage(binding.imageView7, lessons[position].icon)
        }
    }

}