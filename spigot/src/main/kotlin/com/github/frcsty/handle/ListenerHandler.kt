package com.github.frcsty.handle

import com.github.frcsty.FrozenJoinSpigot
import com.github.frcsty.listener.base.PlayerListener
import com.github.frcsty.listener.base.RegionListener
import com.github.frcsty.listener.custom.FrozenJoinListener
import com.github.frcsty.listener.custom.FrozenQuitListener
import com.github.frcsty.listener.custom.FrozenSwitchWorldListener
import com.github.frcsty.listener.custom.worldguard.*
import com.sk89q.worldguard.WorldGuard
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin

class ListenerHandler(plugin: FrozenJoinSpigot) {

    private var listeners: Set<Listener> = setOf(
        PlayerListener(),

        FrozenJoinListener(),
        FrozenQuitListener(),
        FrozenSwitchWorldListener()
    )

    private fun isWorldGuard() {
        val worldGuard: Plugin? = Bukkit.getServer().pluginManager.getPlugin("WorldGuard")
        if (worldGuard == null || worldGuard.isEnabled.not()) {
            return
        }

        WorldGuard.getInstance().platform.sessionManager.registerHandler(RegionListener.factory, null)

        setOf(
            RegionEnteredListener(),
            RegionLeftListener(),
            RegionsChangedListener(),
            RegionsEnteredListener(),
            RegionsLeftListener()
        ).forEach {
            listeners.plus(it)
        }
    }

    init {
        isWorldGuard()

        listeners.forEach{
            Bukkit.getPluginManager().registerEvents(it, plugin)
        }
    }
}