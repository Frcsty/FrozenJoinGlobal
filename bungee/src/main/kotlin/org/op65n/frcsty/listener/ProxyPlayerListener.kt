package com.github.frcsty.listener

import org.op65n.frcsty.event.bungee.FrozenHandshakeEvent
import org.op65n.frcsty.event.bungee.FrozenPostLoginEvent
import com.google.common.eventbus.EventBus
import net.md_5.bungee.api.event.PlayerHandshakeEvent
import net.md_5.bungee.api.event.PostLoginEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler

class ProxyPlayerListener(private val eventBus: EventBus) : Listener {

    @EventHandler
    fun onHandshake(event: PlayerHandshakeEvent) =
            eventBus.post(
	            FrozenHandshakeEvent(
                    event.handshake,
                    event.connection
	                                )
                         )

    @EventHandler
    fun onPostLogin(event: PostLoginEvent) =
            eventBus.post(
	            FrozenPostLoginEvent(
                    event.player
	                                )
                         )
}