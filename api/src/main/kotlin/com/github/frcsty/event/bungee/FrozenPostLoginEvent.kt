package com.github.frcsty.event.bungee

import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.plugin.Event
import org.bukkit.event.Cancellable

class FrozenPostLoginEvent(
        val player: ProxiedPlayer
) : Event(), Cancellable {

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
}