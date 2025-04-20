package ru.neodustry.mdkttools.dispatchers

import arc.Core
import arc.util.Timer
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume

@OptIn(InternalCoroutinesApi::class)
class MindustryMainDispatcher : MainCoroutineDispatcher(), Delay {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        Core.app.post(block)
    }

    override fun isDispatchNeeded(context: CoroutineContext): Boolean {
        return true
    }

    override val immediate: MainCoroutineDispatcher
        get() = this

    @InternalCoroutinesApi
    override fun scheduleResumeAfterDelay(timeMillis: Long, continuation: CancellableContinuation<Unit>) {
        Timer.schedule({
            Core.app.post { continuation.resume(Unit) }
        }, timeMillis / 1000f)
    }

    @InternalCoroutinesApi
    override fun toString(): String = "MindustryMainDispatcher"

    companion object {
        val instance = MindustryMainDispatcher()
    }
}

