package com.github.frcsty.registration

import com.github.frcsty.listener.bungee.FrozenHandshakeListener
import com.github.frcsty.listener.bungee.FrozenPostLoginListener
import com.github.frcsty.listener.spigot.FrozenJoinListener
import com.github.frcsty.listener.spigot.FrozenQuitListener
import com.github.frcsty.listener.spigot.FrozenSwitchWorldListener
import com.github.frcsty.listener.spigot.worldguard.*
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