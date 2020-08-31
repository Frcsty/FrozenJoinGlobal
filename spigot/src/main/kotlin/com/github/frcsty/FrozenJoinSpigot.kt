package com.github.frcsty

import com.github.frcsty.handle.CommandHandler
import com.github.frcsty.handle.ListenerHandler
import com.github.frcsty.handle.MessageHandler
import org.bukkit.plugin.java.JavaPlugin

class FrozenJoinSpigot : JavaPlugin() {

    val registration = ListenerRegistration()

    private val registerable = setOf(
            CommandHandler(this),
            MessageHandler(this)
    )

    override fun onEnable() {
        registration.register(true)

        registerable.plus(ListenerHandler(this, registration.eventBus))
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