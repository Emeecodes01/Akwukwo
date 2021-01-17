package com.mobigods.akwkw.ui.chapter

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.mobigods.akwkw.R
import com.mobigods.akwkw.databinding.FragmentChaptersBinding
import com.mobigods.core.base.BaseFragment

class ChapterFragment: BaseFragment<FragmentChaptersBinding>() {

    private val fragmentArgs: ChapterFragmentArgs by navArgs()

    override val layoutRes: Int
        get() = R.layout.fragment_chapters

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.materialToolbar.title = fragmentArgs.subject.name
        setUpUI()
    }

    private fun setUpUI() {
        binding.materialToolbar.setNavigationOnClickListener {
            goBack()
        }
    }


    override fun observeViewModel() {

    }
}