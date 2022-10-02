package org.op65n.frcsty.handle

import org.op65n.frcsty.FrozenJoinBungee
import org.op65n.frcsty.Registerable
import org.op65n.frcsty.listener.ProxyPlayerListener
import com.google.common.eventbus.EventBus

class ListenerHandler(private val plugin: FrozenJoinBungee, eventBus: EventBus) : Registerable {

    private val listeners = setOf(
            ProxyPlayerListener(eventBus)
    )

    override fun register() {
        listeners.forEach {
            plugin.proxy.pluginManager.registerListener(plugin, it)
        }
    }
}