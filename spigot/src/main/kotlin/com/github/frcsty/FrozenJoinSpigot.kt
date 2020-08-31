package com.github.frcsty

import com.github.frcsty.handle.CommandHandler
import com.github.frcsty.handle.FileHandler
import com.github.frcsty.handle.ListenerHandler
import com.github.frcsty.handle.MessageHandler
import com.github.frcsty.registration.ListenerRegistration
import com.github.frcsty.registration.StorageRegistration
import org.bukkit.plugin.java.JavaPlugin

class FrozenJoinSpigot : JavaPlugin() {

    val listenerRegistration = ListenerRegistration()
    private val storageRegistration = StorageRegistration()

    private val registerable = setOf(
            FileHandler(this),
            CommandHandler(this),
            MessageHandler(this),
            ListenerHandler(this)
    )

    override fun onEnable() {
        saveDefaultConfig()

        listenerRegistration.register(true)
        storageRegistration.initializeFormats("$dataFolder/formats.yml")
        storageRegistration.initializeMotds("$dataFolder/motds.yml")

        registerable.forEach { it.register() }
    }

    override fun onDisable() {
        reloadConfig()
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