package com.github.frcsty.handle

import com.github.frcsty.FrozenJoinSpigot
import com.github.frcsty.Registerable
import com.github.frcsty.command.admin.HelpCommand
import com.github.frcsty.command.admin.ReloadCommand
import com.github.frcsty.command.user.FormatCommand
import com.github.frcsty.command.user.MotdCommand
import me.mattstudios.mf.base.CommandManager

class CommandHandler(private val plugin: FrozenJoinSpigot) : Registerable
{

    private var commands = setOf(
        HelpCommand(plugin),
        ReloadCommand(plugin),

        FormatCommand(),
        MotdCommand()
    )

    override fun identifier() = "command"

    override fun register() {
        val manager = CommandManager(plugin)

        commands.forEach { manager.register(it) }
    }

}