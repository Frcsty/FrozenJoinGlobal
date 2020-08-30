package com.github.frcsty.event.spigot

import org.bukkit.World
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class FrozenSwitchWorldEvent(
        var player: Player,
        var from: World
): Event(), Cancellable {

    override fun getHandlers() = handlerList

    /**
     * Sets the status of the event.
     *
     * @param cancel Dictates whether the event should be cancelled
     */
    override fun setCancelled(cancel: Boolean) {
        this.isCancelled = cancel
    }

    /**
     * Returns whether the event has been cancelled.
     *
     * @return isCancelled
     */
    override fun isCancelled(): Boolean = this.isCancelled

    companion object {
        @JvmStatic
        private val handlerList = HandlerList()
    }
}