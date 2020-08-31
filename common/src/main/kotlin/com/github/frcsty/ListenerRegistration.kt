package com.github.frcsty

import com.github.frcsty.listener.bungee.FrozenHandshakeListener
import com.github.frcsty.listener.bungee.FrozenPostLoginListener
import com.github.frcsty.listener.spigot.FrozenJoinListener
import com.github.frcsty.listener.spigot.FrozenQuitListener
import com.github.frcsty.listener.spigot.FrozenSwitchWorldListener
import com.github.frcsty.listener.spigot.worldguard.*
import com.google.common.eventbus.EventBus

class ListenerRegistration {

    private val spigotListeners = setOf(
            FrozenJoinListener,
            FrozenQuitListener,
            FrozenSwitchWorldListener,

            RegionEnteredListener,
            RegionLeftListener,
            RegionsChangedListener,
            RegionsEnteredListener,
            RegionsLeftListener
    )

    private val bungeeListeners = setOf(
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