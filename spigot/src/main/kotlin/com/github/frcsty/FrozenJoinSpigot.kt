package com.github.frcsty

import com.github.frcsty.handle.ListenerHandler
import org.bukkit.plugin.java.JavaPlugin

class FrozenJoinSpigot : JavaPlugin() {

    override fun onEnable() {
        ListenerHandler(this)
    }

    override fun onDisable() {

    }
}