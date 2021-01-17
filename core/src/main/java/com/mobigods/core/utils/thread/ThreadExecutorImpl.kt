package com.mobigods.core.utils.thread

import com.mobigods.domain.thread.ExecutionThread
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ThreadExecutorImpl @Inject constructor(): ExecutionThread {

    override fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    override fun ui(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun default(): CoroutineDispatcher {
        return Dispatchers.Default
    }

}