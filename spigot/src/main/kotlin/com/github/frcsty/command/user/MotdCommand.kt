package com.github.frcsty.command.user

import me.mattstudios.mf.annotations.Command
import me.mattstudios.mf.annotations.Default
import me.mattstudios.mf.annotations.Permission
import me.mattstudios.mf.base.CommandBase
import org.bukkit.entity.Player

@Command("motd")
class MotdCommand : CommandBase() {

    companion object {
        private const val PERMISSION = "frozenjoin.command.motd"
    }

    @Default
    @Permission(PERMISSION)
    fun onCommand(sender: Player) {

    }
}