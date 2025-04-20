package ru.neodustry.mdkttools.utils

import arc.util.CommandHandler
import mindustry.gen.Player

fun CommandHandler.registerAdmin(text: String, args_desc: String, description: String, runner: (Array<String>, Player) -> Unit): Unit{
    this.register<Player>(text, args_desc, description) { args, player ->
        if (player.admin) {
            runner(args, player)
        } else {
            player.sendMessage("You are not admin")
        }
    }
}