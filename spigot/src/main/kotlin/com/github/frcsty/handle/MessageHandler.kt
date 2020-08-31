package com.github.frcsty.handle

import com.github.frcsty.FrozenJoinSpigot
import com.github.frcsty.Registerable
import com.github.frcsty.util.error
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class MessageHandler(private val plugin: FrozenJoinSpigot) : Registerable
{

    private val messages = mutableMapOf<String, Any?>()

    override fun identifier() = "message"

    override fun register() {
        val file = File("${plugin.dataFolder}/messages.yml")
        val configuration: FileConfiguration? = YamlConfiguration.loadConfiguration(file)

        if (configuration == null) {
            error(plugin, "File configuration 'messages.yml' has not been found!")
            return
        }

        val section = configuration.getConfigurationSection("messages")
        if (section == null) {
            error(plugin, "File section 'messages' has not been found within 'messages.yml'!")
            return
        }

        for (message in section.getKeys(false)) {
            messages[message] = section.get(message)
        }
    }

    fun get(key: String): Any {
        return messages[key]?: return "Object key '$key' has not been found within 'messages.yml'!"
    }
}