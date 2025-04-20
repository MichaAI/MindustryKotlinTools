@file:OptIn(DelicateCoroutinesApi::class)

package ru.neodustry.mdkttools.utils

import arc.Events
import arc.func.Cons
import arc.struct.Seq
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun <T> Events.onAsync(type: Class<T?>, listener: Cons<T?>) {
    Events.on(type) { t: T? ->
        GlobalScope.launch(Dispatchers.Main) {
            listener.get(t)
        }
    }
}