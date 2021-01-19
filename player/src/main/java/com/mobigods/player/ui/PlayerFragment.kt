package com.mobigods.player.ui

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
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

        playerFragmentArgs.lesson?.let {
            binding.lessonName.text = it.name
        }

        setUpExoPlayer()

        binding.materialToolbar2.setNavigationOnClickListener {
            savePlayedLesson()
            goBack()
        }

        binding.details.text = playerFragmentArgs.chapterName

        setBackPressedListener {
            savePlayedLesson()
        }
    }


    private fun savePlayedLesson() {
        val playedLesson = RecentLessonModel(
            id = if (playerFragmentArgs.recentLesson == null) generateRandomId() else playerFragmentArgs.recentLesson!!.id,
            chapterName = playerFragmentArgs.chapterName,
            watchedDuration = exoPlayer.currentPosition,
            lesson = createLesson()
        )
        playerViewModel.saveRecentLesson(playedLesson)
    }


    private fun createLesson(): LessonModel {
        val recentLesson = playerFragmentArgs.recentLesson?.lesson
        val lesson = playerFragmentArgs.lesson
        return when {
            recentLesson != null -> {
                LessonModel(
                    chapter_id = recentLesson.chapter_id,
                    icon = recentLesson.icon,
                    id = recentLesson.id,
                    media_url = recentLesson.media_url,
                    name = recentLesson.name,
                    subject_id = recentLesson.subject_id
                )
            }

            lesson != null -> {
                LessonModel(
                    chapter_id = lesson.chapter_id,
                    icon = lesson.icon,
                    id = lesson.id,
                    media_url = lesson.media_url,
                    name = lesson.name,
                    subject_id = lesson.subject_id
                )
            }
            else -> {
                //not possible
                LessonModel(0, "", 0, "", "", 0)
            }
        }

    }

    private fun generateRandomId(): String {
        return UUID.randomUUID().toString().replace("-", "");
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        requireContext().setTheme(R.style.Akwukwo_Main_TranslucentStatus2)
    }

    override fun observeViewModel() {
        with(playerViewModel) {

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
            val mediaUrl = playerFragmentArgs.lesson?.let { it.media_url } ?: playerFragmentArgs.recentLesson?.lesson?.media_url ?: ""
            setUri(Uri.parse(mediaUrl))
        }

        exoPlayer.setMediaItem(mediaItem)
        binding.playerView.player = exoPlayer

        playerFragmentArgs.recentLesson?.let {
            exoPlayer.seekTo(it.watchedDuration)
        }

        exoPlayer.prepare()
        exoPlayer.play()
    }


    override fun onDestroy() {
        exoPlayer.release()
        super.onDestroy()
    }

}