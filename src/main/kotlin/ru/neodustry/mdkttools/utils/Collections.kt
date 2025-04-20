package ru.neodustry.mdkttools.utils

import arc.struct.Seq

fun <T> List<T>.toSeq(): Seq<T> {
    val seq = Seq<T>()
    this.forEach { seq.add(it) }
    return seq
}

inline fun <reified T> Seq<T?>.toList(): MutableList<T?> {
    val list: MutableList<T?> = mutableListOf()
    this.forEach { list.add(it) }
    return list
}

fun <T> Array<T>.toSeq(): Seq<T> {
    val seq = Seq<T>()
    this.forEach { seq.add(it) }
    return seq
}

