package com.mobigods.akwkw.ui.subject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobigods.akwkw.R
import com.mobigods.akwkw.databinding.FragmentDashboardBinding
import com.mobigods.akwkw.ui.chapter.ChapterFragmentDirections
import com.mobigods.akwkw.ui.chapter.ChapterFragmentDirections.actionChapterFragmentToPlayerFragment
import com.mobigods.akwkw.ui.subject.adapter.RecentLessonAdapter
import com.mobigods.akwkw.ui.subject.adapter.SubjectAdapter
import com.mobigods.akwkw.ui.subject.decorations.SubjectsItemDecoration
import com.mobigods.akwkw.ui.subject.decorations.VerticalListDecoration
import com.mobigods.core.base.BaseFragment
import com.mobigods.core.utils.states.AkwukwoState
import com.mobigods.presentation.models.LessonModel
import com.mobigods.presentation.models.PlayerData
import com.mobigods.presentation.models.RecentLessonWithSubjectModel
import com.mobigods.presentation.models.SubjectModel
import com.mobigods.presentation.viewmodels.AkwukwoViewModelFactory
import com.mobigods.presentation.viewmodels.dashboard.DashBoardViewModel
import dagger.android.support.AndroidSupportInjection
import jp.wasabeef.recyclerview.animators.LandingAnimator
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class DashboardFragment: BaseFragment<FragmentDashboardBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val dashBoardViewModel: DashBoardViewModel by viewModels { viewModelFactory }
    private val subjectAdapter: SubjectAdapter by lazy { SubjectAdapter{ subjectItemClicked(it) } }


    private val recentAdapter: RecentLessonAdapter by lazy { RecentLessonAdapter {
        navigateToPlayer(it)
    } }


    private fun navigateToPlayer(recentLessonWithSubjectModel: RecentLessonWithSubjectModel) {
        val playerData = PlayerData.createFromRecentLesson(recentLessonWithSubjectModel)
        val lessonPlayerDirection = DashboardFragmentDirections.actionDashboardFragmentToPlayerFragment(playerData)

        navigateTo(lessonPlayerDirection)
    }


    override val layoutRes: Int
        get() = R.layout.fragment_dashboard
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        dashBoardViewModel.getSubjects()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    private fun setUpUI() {
        binding.subjectsRv.apply {
            itemAnimator = SlideInDownAnimator().apply {
                addDuration = 300
                removeDuration = 300
                moveDuration = 300
                changeDuration = 300
            }
            layoutManager = GridLayoutManager(requireContext(), 2)
            addItemDecoration(SubjectsItemDecoration(resources.getDimension(R.dimen.rv_item_spacing).toInt()))
            adapter = subjectAdapter
        }

        binding.recentRv.apply {
            itemAnimator = SlideInRightAnimator().apply {
                addDuration = 300
                removeDuration = 300
                moveDuration = 300
                changeDuration = 300
            }
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(VerticalListDecoration(resources.getDimension(R.dimen.rv_item_spacing).toInt()))
            adapter = recentAdapter
        }
    }


    private fun subjectItemClicked(subjectModel: SubjectModel) {
        val directions = DashboardFragmentDirections.actionDashboardFragmentToChapterFragment(subjectModel)
        navigateTo(directions)
    }


    override fun observeViewModel() {
        with(dashBoardViewModel) {

            subject.observe(viewLifecycleOwner) { resource ->
                when(resource.state) {
                    AkwukwoState.SUCCESS -> {
                        resource.data?.let {
                            subjectAdapter.subjects = it
                            dashBoardViewModel.getRecentLessons()
                        }
                    }
                    else -> {}
                }
            }

            subjectRemote.observe(viewLifecycleOwner) { resource ->
                when(resource.state) {
                    AkwukwoState.LOADING -> {
                        showLoading()
                    }

                    AkwukwoState.SUCCESS -> {
                        hideLoading()
                        showSnackMessage("Subjects Fetched successfully")
                    }

                    AkwukwoState.ERROR -> {
                        hideLoading()
                        resource.message?.let { showSnackMessage(it) }
                    }
                }
            }

            recent.observe(viewLifecycleOwner) { resource ->

                when(resource.state) {
                    AkwukwoState.SUCCESS -> {
                        resource.data?.let {
                            if (it.isEmpty()) {
                                binding.showRecent = false
                                return@let
                            }
                            binding.showRecent = true
                            recentAdapter.recents = it
                        }

                    }
                    else -> {

                    }
                }

            }

        }
    }

}