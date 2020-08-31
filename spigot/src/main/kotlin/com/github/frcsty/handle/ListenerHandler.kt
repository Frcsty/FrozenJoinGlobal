package com.github.frcsty.handle

import com.github.frcsty.FrozenJoinSpigot
import com.github.frcsty.Registerable
import com.github.frcsty.listener.PlayerListener
import com.github.frcsty.listener.RegionListener
import com.google.common.eventbus.EventBus
import com.sk89q.worldguard.WorldGuard

class ListenerHandler(private val plugin: FrozenJoinSpigot) : Registerable {

    private val listeners = setOf(
            PlayerListener(plugin.listenerRegistration.eventBus)
    )

    /**
     * Checks if the server is running WorldGuard,
     * if it is, initialized it's listeners for region
     * support.
     */
    private fun registerWorldGuard() {
        plugin.server.pluginManager.getPlugin("WorldGuard")?: return

        val worldGuard: WorldGuard? = WorldGuard.getInstance() ?: return
        worldGuard?.platform?.sessionManager?.registerHandler(RegionListener.factory, null)
    }

    override fun identifier() = "listener"

    override fun register() {
        registerWorldGuard()

        listeners.forEach {
            plugin.server.pluginManager.registerEvents(it, plugin)
        }
    }

}