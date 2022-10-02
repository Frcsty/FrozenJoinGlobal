package org.op65n.frcsty.event.bungee

import net.md_5.bungee.api.connection.PendingConnection
import net.md_5.bungee.api.plugin.Event
import net.md_5.bungee.protocol.packet.Handshake
import org.bukkit.event.Cancellable

class FrozenHandshakeEvent(
        val handshake: Handshake,
        val connection: PendingConnection
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