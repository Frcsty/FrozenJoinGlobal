package com.github.frcsty.command.admin

import com.github.frcsty.FrozenJoinSpigot
import me.mattstudios.mf.annotations.Command
import me.mattstudios.mf.annotations.Permission
import me.mattstudios.mf.annotations.SubCommand
import me.mattstudios.mf.base.CommandBase
import org.bukkit.command.CommandSender

@Command("frozenjoin")
class ReloadCommand(private val plugin: FrozenJoinSpigot) : CommandBase() {

    companion object {
        private const val PERMISSION = "frozenjoin.command.reload"
        private const val COMMAND = "reload"
    }

    @SubCommand(COMMAND)
    @Permission(PERMISSION)
    fun onCommand(sender: CommandSender) {
        val start = System.currentTimeMillis()


    }
}