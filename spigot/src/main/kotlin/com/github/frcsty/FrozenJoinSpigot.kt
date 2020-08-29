package com.github.frcsty

import com.github.frcsty.handle.CommandHandler
import com.github.frcsty.handle.ListenerHandler
import com.github.frcsty.handle.MessageHandler
import org.bukkit.plugin.java.JavaPlugin

class FrozenJoinSpigot : JavaPlugin() {

    private val registerable = setOf(
        ListenerHandler(this),
        CommandHandler(this),
        MessageHandler(this)
    )

    override fun onEnable() {
       registerable.forEach { it.register() }
    }

    override fun onDisable() {

    }

    fun getRegisterable(identifier: String): Registerable? {
        for (registerable in this.registerable) {
            if (registerable.identifier().equals(identifier, ignoreCase = true)) {
                return registerable
            }
        }

        return null
    }
}