package com.github.frcsty.command.admin

import com.github.frcsty.FrozenJoinSpigot
import com.github.frcsty.handle.MessageHandler
import com.github.frcsty.util.color
import com.github.frcsty.util.simpleColor
import me.mattstudios.mf.annotations.Command
import me.mattstudios.mf.annotations.Permission
import me.mattstudios.mf.annotations.SubCommand
import me.mattstudios.mf.base.CommandBase
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@Suppress("unused")
@Command("frozenjoin")
class HelpCommand(private val plugin: FrozenJoinSpigot) : CommandBase() {

    companion object {
        private const val PERMISSION = "frozenjoin.command.help"
        private const val COMMAND = "help"

        private const val HELP_MESSAGE = "help-command"
    }

    @Suppress("UNCHECKED_CAST")
    @SubCommand(COMMAND)
    @Permission(PERMISSION)
    fun onCommand(sender: CommandSender) {
        val handler = plugin.getRegisterable("message") as MessageHandler
        val message = handler.get(HELP_MESSAGE)
        if (message !is List<*>) {
            sender.sendMessage(message.toString())
            return
        }

        val listMessage = message as List<String>
        if (sender !is Player) {
            for (line in listMessage) {
                sender.sendMessage(line.replace(
                        "{version}",
                        plugin.description.version).simpleColor()
                )
            }
            return
        }

        for (line in listMessage) {
            if (line.isEmpty()) {
                sender.sendMessage("")
                continue
            }
            line.replace(
                    "{version}",
                    plugin.description.version
            ).color().sendMessage(sender)
        }
    }
}