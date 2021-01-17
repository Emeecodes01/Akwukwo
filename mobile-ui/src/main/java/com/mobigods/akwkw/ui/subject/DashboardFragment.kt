package com.mobigods.akwkw.ui.subject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.mobigods.akwkw.R
import com.mobigods.akwkw.databinding.FragmentDashboardBinding
import com.mobigods.akwkw.ui.subject.adapter.SubjectAdapter
import com.mobigods.akwkw.ui.subject.decorations.SubjectsItemDecoration
import com.mobigods.core.base.BaseFragment
import com.mobigods.core.utils.states.AkwukwoState
import com.mobigods.presentation.models.SubjectModel
import com.mobigods.presentation.viewmodels.AkwukwoViewModelFactory
import com.mobigods.presentation.viewmodels.dashboard.DashBoardViewModel
import dagger.android.support.AndroidSupportInjection
import jp.wasabeef.recyclerview.animators.LandingAnimator
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class DashboardFragment: BaseFragment<FragmentDashboardBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val dashBoardViewModel: DashBoardViewModel by viewModels { viewModelFactory }
    private val subjectAdapter: SubjectAdapter by lazy { SubjectAdapter{ subjectItemClicked(it) } }


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
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2)
            addItemDecoration(SubjectsItemDecoration(resources.getDimension(R.dimen.rv_item_spacing).toInt()))
            itemAnimator = LandingAnimator().apply {
                addDuration = 500
                removeDuration = 500
                moveDuration = 500
                changeDuration = 500
            }
            adapter = subjectAdapter
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
                            if (it.isEmpty()) binding.showRecent = false
                            subjectAdapter.subjects = it
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

        }
    }

}