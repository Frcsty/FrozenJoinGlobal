package com.github.frcsty.handle

import com.github.frcsty.FrozenJoinSpigot
import com.github.frcsty.Registerable
import com.github.frcsty.listener.base.PlayerListener
import com.github.frcsty.listener.base.RegionListener
import com.github.frcsty.listener.custom.FrozenJoinListener
import com.github.frcsty.listener.custom.FrozenQuitListener
import com.github.frcsty.listener.custom.FrozenSwitchWorldListener
import com.github.frcsty.listener.custom.worldguard.*
import com.sk89q.worldguard.WorldGuard
import org.bukkit.Bukkit

class ListenerHandler(private val plugin: FrozenJoinSpigot) : Registerable {

    private val listeners = setOf(
        PlayerListener,

        FrozenJoinListener(),
        FrozenQuitListener(),
        FrozenSwitchWorldListener()
    )

    /**
     * Checks if the server is running WorldGuard,
     * if it is, initialized it's listeners for region
     * support.
     */
    private fun registerWorldGuard() {
        val worldGuard: WorldGuard? = WorldGuard.getInstance()?: return

        worldGuard?.platform?.sessionManager?.registerHandler(RegionListener.factory, null)
        setOf(
            RegionEnteredListener(),
            RegionLeftListener(),
            RegionsChangedListener(),
            RegionsEnteredListener(),
            RegionsLeftListener()
        ).forEach {
            listeners.plus(it)
        }
    }

    override fun identifier() = "listener"

    override fun register() {
        registerWorldGuard()

        listeners.forEach {
            Bukkit.getPluginManager().registerEvents(it, plugin)
        }
    }

}