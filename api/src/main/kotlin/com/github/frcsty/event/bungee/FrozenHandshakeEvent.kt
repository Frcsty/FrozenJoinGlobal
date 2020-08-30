package com.github.frcsty.event.bungee

import net.md_5.bungee.api.connection.PendingConnection
import net.md_5.bungee.protocol.packet.Handshake
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class FrozenHandshakeEvent(
        val handshake: Handshake,
        val connection: PendingConnection
) : Event(), Cancellable {

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