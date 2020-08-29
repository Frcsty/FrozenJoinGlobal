package com.github.frcsty.command.user

import me.mattstudios.mf.annotations.Command
import me.mattstudios.mf.annotations.Default
import me.mattstudios.mf.annotations.Permission
import me.mattstudios.mf.base.CommandBase
import org.bukkit.entity.Player

@Command("format")
class FormatCommand : CommandBase() {

    companion object {
        private const val PERMISSION = "frozenjoin.command.format"
    }

    @Default
    @Permission(PERMISSION)
    fun onCommand(player: Player) {

    }
}