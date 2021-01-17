package com.mobigods.akwkw.ui.chapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobigods.akwkw.databinding.LayoutChapterItemBinding
import com.mobigods.akwkw.ui.chapter.ChapterFragmentArgs
import com.mobigods.core.utils.extensions.checkAndUpdateItems
import com.mobigods.core.utils.layoutmanagers.AnimatedLinearLayoutManager
import com.mobigods.core.utils.image.ImageLoader
import com.mobigods.core.utils.layoutmanagers.AnimatedHorizontalLinearLayoutManager
import com.mobigods.presentation.models.ChapterModel
import com.mobigods.presentation.models.LessonModel
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import javax.inject.Inject
import kotlin.properties.Delegates


class ChapterAdapter @Inject constructor(private val imageLoader: ImageLoader): RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>() {
    private lateinit var binding: LayoutChapterItemBinding

    var chapterAdapterInterface: ChapterAdapterInterface? = null

    var chapters: List<ChapterModel> by Delegates.observable(emptyList()) {_, oldList, newList ->
        checkAndUpdateItems(oldList, newList) { old, new ->
            old.id== new.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        binding = LayoutChapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChapterViewHolder(binding.root)
    }


    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount() = chapters.size


    inner class ChapterViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(position: Int) {
            binding.chapter = chapters[position]

            val lessonAdapter = LessonAdapter(imageLoader) {
                chapterAdapterInterface?.onLessonClicked(it, chapters[position].name)
            }

            binding.lessonsRv.apply {
                itemAnimator = SlideInDownAnimator().apply {
                    addDuration = 1000
                    removeDuration = 1000
                    moveDuration = 1000
                    changeDuration = 1000
                }
                layoutManager = AnimatedHorizontalLinearLayoutManager(itemView.context)
                adapter = lessonAdapter
            }

            lessonAdapter.lessons = chapters[position].lessons
        }
    }

    interface ChapterAdapterInterface {
        fun onLessonClicked(lessonModel: LessonModel, chapterName: String)
    }

}