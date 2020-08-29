package com.github.frcsty.util

import me.mattstudios.mfmsg.base.Message
import me.mattstudios.mfmsg.base.internal.MessageComponent
import net.md_5.bungee.api.ChatColor
import org.bukkit.plugin.Plugin
import java.util.logging.Level

fun String.color(): MessageComponent {
    return Message.create().parse(this)
}

fun String.simpleColor(): String {
    return ChatColor.translateAlternateColorCodes('&', this)
}

/**
 * Logging Utilities
 */
fun log(plugin: Plugin, level: Level, text: String) {
    plugin.logger.log(level, text)
}

fun info(plugin: Plugin, text: String) {
    log(plugin, Level.INFO, text)
}

fun error(plugin: Plugin, text: String) {
    log(plugin, Level.SEVERE, text)
}

fun warning(plugin: Plugin, text: String) {
    log(plugin, Level.WARNING, text)
}

