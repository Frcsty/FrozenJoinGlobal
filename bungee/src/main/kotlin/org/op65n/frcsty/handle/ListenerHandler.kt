package com.github.frcsty.handle

import com.github.frcsty.FrozenJoinBungee
import com.github.frcsty.Registerable
import com.github.frcsty.listener.ProxyPlayerListener
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