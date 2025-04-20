package ru.neodustry.mdkttools.dispatchers

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.internal.MainDispatcherFactory

@OptIn(InternalCoroutinesApi::class)
class MindustryMainDispatcherFactory : MainDispatcherFactory {
    @InternalCoroutinesApi
    override val loadPriority: Int
        get() = 1000

    @InternalCoroutinesApi
    override fun createDispatcher(allFactories: List<MainDispatcherFactory>): MainCoroutineDispatcher {
        return MindustryMainDispatcher.instance
    }

    override fun hintOnError(): String {
        return "Are you launch from Mindustry?"
    }
}