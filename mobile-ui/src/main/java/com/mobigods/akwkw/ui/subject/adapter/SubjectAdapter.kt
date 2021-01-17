package com.mobigods.akwkw.ui.subject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mobigods.akwkw.databinding.LayoutSubjectItemBinding
import com.mobigods.akwkw.ui.subject.diffs.SubjectDiff
import com.mobigods.core.utils.extensions.checkAndUpdateItems
import com.mobigods.core.utils.extensions.click
import com.mobigods.presentation.models.SubjectModel
import kotlin.properties.Delegates

class SubjectAdapter(private val onClick: (SubjectModel) -> Unit): RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {
    private lateinit var binding: LayoutSubjectItemBinding

    var subjects: List<SubjectModel> by Delegates.observable(emptyList()) { _, oldList, newList ->
        checkAndUpdateItems(oldList, newList) { old, new ->
            old.id == new.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        binding = LayoutSubjectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubjectViewHolder(binding.root)
    }


    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bindViews(position)
    }

    override fun getItemCount() = subjects.size

    inner class SubjectViewHolder(view: View): RecyclerView.ViewHolder(view) {
        init {
            binding.subjectCard.click {
                onClick.invoke(subjects[adapterPosition])
            }
        }

        fun bindViews(position: Int) {
            binding.subject = subjects[position]
        }
    }

}