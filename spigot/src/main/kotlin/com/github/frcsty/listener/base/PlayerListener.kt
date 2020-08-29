package com.github.frcsty.listener.base

import com.github.frcsty.event.FrozenJoinEvent
import com.github.frcsty.event.FrozenQuitEvent
import com.github.frcsty.event.FrozenSwitchWorldEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChangedWorldEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

object PlayerListener : Listener {

    private val manager = Bukkit.getPluginManager()

    /**
     * Called when a player joins a spigot server.
     *
     * Calls [FrozenJoinEvent]
     */
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        manager.callEvent(FrozenJoinEvent(
            event.joinMessage,
            event.player)
        )
    }

    /**
     * Called when a player leaves a spigot server.
     *
     * Calls [FrozenQuitEvent]
     */
    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        manager.callEvent(FrozenQuitEvent(
            event.quitMessage,
            event.player
        ))
    }

    /**
     * Called when a player switches a world.
     *
     * Calls [FrozenSwitchWorldEvent]
     */
    @EventHandler
    fun onPlayerWorldSwitch(event: PlayerChangedWorldEvent) {
        manager.callEvent(FrozenSwitchWorldEvent(
            event.player,
            event.from
        ))
    }

}