package com.mobigods.player.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.ControlDispatcher
import com.google.android.exoplayer2.DefaultControlDispatcher
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.mobigods.core.base.BaseFragment
import com.mobigods.player.R
import com.mobigods.player.databinding.FragmentPlayerBinding
import com.mobigods.player.di.inject
import com.mobigods.player.utils.Constants
import com.mobigods.player.utils.exoplayer
import com.mobigods.player.utils.mediaitem
import com.mobigods.presentation.models.LessonModel
import com.mobigods.presentation.models.RecentLessonModel
import com.mobigods.presentation.viewmodels.player.PlayerViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class PlayerFragment : BaseFragment<FragmentPlayerBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val playerViewModel: PlayerViewModel by viewModels { viewModelFactory }

    private lateinit var exoPlayer: SimpleExoPlayer
    private val playerFragmentArgs: PlayerFragmentArgs by navArgs()

    override val layoutRes: Int
        get() = R.layout.fragment_player


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playerFragmentArgs.playerData.lessonName.let {
            binding.lessonName.text = it
        }

        setUpExoPlayer()

        binding.materialToolbar2.setNavigationOnClickListener {
            savePlayedLesson()
        }

        binding.details.text = playerFragmentArgs.playerData.chapterName

        setBackPressedListener {
            savePlayedLesson()
        }
    }


    private fun savePlayedLesson() {
        playerViewModel.saveRecentLesson(exoPlayer.currentPosition, playerFragmentArgs.playerData)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        requireContext().setTheme(R.style.Akwukwo_Main_TranslucentStatus2)
    }

    override fun observeViewModel() {
        with(playerViewModel) {
            lessons.observe(viewLifecycleOwner) { saved ->
                if (saved) goBack()
            }
        }
    }


    private fun setUpExoPlayer() {
        binding.playerView.apply {
            setControlDispatcher(DefaultControlDispatcher(Constants.FORWARD_TIME, Constants.RE_WIND_TIME))
            setShowNextButton(false)
            setShowPreviousButton(false)
        }


        exoPlayer = exoplayer {}

        val mediaItem = mediaitem {
            val mediaUrl = playerFragmentArgs.playerData.mediaUrl
            setUri(Uri.parse(mediaUrl))
        }

        exoPlayer.setMediaItem(mediaItem)
        binding.playerView.player = exoPlayer

        playerFragmentArgs.playerData.watchedDuration.let {
            exoPlayer.seekTo(it)
        }

        exoPlayer.prepare()
        exoPlayer.play()
    }


    override fun onDestroy() {
        exoPlayer.release()
        super.onDestroy()
    }

}