package org.op65n.frcsty.registration

import org.op65n.frcsty.listener.bungee.FrozenHandshakeListener
import org.op65n.frcsty.listener.bungee.FrozenPostLoginListener
import org.op65n.frcsty.listener.spigot.FrozenJoinListener
import org.op65n.frcsty.listener.spigot.FrozenQuitListener
import org.op65n.frcsty.listener.spigot.FrozenSwitchWorldListener
import org.op65n.frcsty.listener.spigot.worldguard.*
import com.google.common.eventbus.EventBus

class ListenerRegistration {

    private val spigotListeners = mutableListOf(
            FrozenJoinListener,
            FrozenQuitListener,
            FrozenSwitchWorldListener,

            RegionEnteredListener,
            RegionLeftListener,
            RegionsChangedListener,
            RegionsEnteredListener,
            RegionsLeftListener
    )

    private val bungeeListeners = mutableListOf(
            FrozenHandshakeListener,
            FrozenPostLoginListener
    )

    val eventBus = EventBus()

    fun register(spigot: Boolean) {
        if (spigot) {
            spigotListeners.forEach { eventBus.register(it) }
        } else {
            bungeeListeners.forEach { eventBus.register(it) }
        }
    }
}