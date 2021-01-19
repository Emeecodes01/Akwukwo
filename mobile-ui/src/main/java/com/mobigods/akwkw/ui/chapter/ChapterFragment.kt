package com.mobigods.akwkw.ui.chapter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobigods.akwkw.R
import com.mobigods.akwkw.databinding.FragmentChaptersBinding
import com.mobigods.akwkw.ui.chapter.adapter.ChapterAdapter
import com.mobigods.akwkw.ui.subject.decorations.SubjectsItemDecoration
import com.mobigods.core.base.BaseFragment
import com.mobigods.core.utils.image.ImageLoader
import com.mobigods.core.utils.layoutmanagers.AnimatedHorizontalLinearLayoutManager
import com.mobigods.core.utils.layoutmanagers.AnimatedLinearLayoutManager
import com.mobigods.presentation.models.LessonModel
import com.mobigods.presentation.models.PlayerData
import com.mobigods.presentation.viewmodels.AkwukwoViewModelFactory
import com.mobigods.presentation.viewmodels.chapter.ChapterViewModel
import dagger.android.support.AndroidSupportInjection
import jp.wasabeef.recyclerview.animators.LandingAnimator
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator
import kotlinx.coroutines.delay
import javax.inject.Inject

class ChapterFragment: BaseFragment<FragmentChaptersBinding>(), ChapterAdapter.ChapterAdapterInterface{

    @Inject
    lateinit var chaptersAdapter: ChapterAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val chapterViewModel: ChapterViewModel by viewModels { viewModelFactory }

    private val fragmentArgs: ChapterFragmentArgs by navArgs()

    override val layoutRes: Int
        get() = R.layout.fragment_chapters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.materialToolbar.title = fragmentArgs.subject.name
        setUpUI()

    }

    private fun setUpUI() {
        binding.materialToolbar.setNavigationOnClickListener {
            goBack()
        }
        chaptersAdapter.chapterAdapterInterface = this
        binding.chaptersRv.apply {
            itemAnimator = SlideInDownAnimator().apply {
                addDuration = 500
                removeDuration = 500
                moveDuration = 500
                changeDuration = 500
            }
            layoutManager = AnimatedLinearLayoutManager(requireContext())
            adapter = chaptersAdapter
        }

        chaptersAdapter.chapters = fragmentArgs.subject.chapters
    }


    override fun observeViewModel() {

    }

    override fun onLessonClicked(lessonModel: LessonModel, chapterName: String) {
        chapterViewModel.saveLesson(lessonModel)
        val playerData = PlayerData.createFromLesson(lessonModel, chapterName)
        val lessonPlayerDirection = ChapterFragmentDirections
            .actionChapterFragmentToPlayerFragment(playerData)
        navigateTo(lessonPlayerDirection)
    }

}