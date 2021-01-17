package com.mobigods.player.ui

import android.net.Uri
import android.os.Bundle
import android.view.View
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

class PlayerFragment : BaseFragment<FragmentPlayerBinding>() {

    private lateinit var exoPlayer: SimpleExoPlayer
    private val playerFragmentArgs: PlayerFragmentArgs by navArgs()

    override val layoutRes: Int
        get() = R.layout.fragment_player


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lessonName.text = playerFragmentArgs.lesson.name
        setUpExoPlayer()

        binding.materialToolbar2.setNavigationOnClickListener {
            goBack()
        }

        binding.details.text = playerFragmentArgs.chapterName

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        requireContext().setTheme(R.style.Akwukwo_Main_TranslucentStatus2)
    }

    override fun observeViewModel() {

    }


    private fun setUpExoPlayer() {
        binding.playerView.apply {
            setControlDispatcher(DefaultControlDispatcher(Constants.FORWARD_TIME, Constants.RE_WIND_TIME))
            setShowNextButton(false)
            setShowPreviousButton(false)
        }


        exoPlayer = exoplayer {}

        val mediaItem = mediaitem {
            setUri(Uri.parse(playerFragmentArgs.lesson.media_url))
        }

        exoPlayer.setMediaItem(mediaItem)
        binding.playerView.player = exoPlayer

        exoPlayer.prepare()
        exoPlayer.play()
    }


    override fun onDestroy() {
        exoPlayer.release()
        super.onDestroy()
    }

}