package com.github.frcsty.listener

import com.google.common.eventbus.EventBus
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChangedWorldEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class PlayerListener(private val eventBus: EventBus) : Listener {

    /**
     * Called when a player joins a spigot server.
     *
     * Calls [FrozenJoinEvent]
     */
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) =
            eventBus.post(FrozenJoinEvent(
                    event.joinMessage,
                    event.player)
            )

    /**
     * Called when a player leaves a spigot server.
     *
     * Calls [FrozenQuitEvent]
     */
    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) =
            eventBus.post(FrozenQuitEvent(
                    event.quitMessage,
                    event.player
            ))

    /**
     * Called when a player switches a world.
     *
     * Calls [FrozenSwitchWorldEvent]
     */
    @EventHandler
    fun onPlayerWorldSwitch(event: PlayerChangedWorldEvent) =
            eventBus.post(FrozenSwitchWorldEvent(
                    event.player,
                    event.from
            ))

}