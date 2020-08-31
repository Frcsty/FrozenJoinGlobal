package com.github.frcsty.listener

import com.github.frcsty.FrozenJoinSpigot
import com.github.frcsty.event.spigot.worldguard.*
import com.google.common.eventbus.EventBus
import com.sk89q.worldedit.util.Location
import com.sk89q.worldguard.LocalPlayer
import com.sk89q.worldguard.protection.ApplicableRegionSet
import com.sk89q.worldguard.protection.regions.ProtectedRegion
import com.sk89q.worldguard.session.MoveType
import com.sk89q.worldguard.session.Session
import com.sk89q.worldguard.session.handler.Handler
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class RegionListener(private val eventBus: EventBus, session: Session?) : Handler(session), Listener {

    class Factory(private val eventBus: EventBus) : Handler.Factory<RegionListener>() {
        override fun create(session: Session): RegionListener {
            return RegionListener(eventBus, session)
        }
    }

    /**
     * Checks if the user has switched a region,
     * if so, calls the corresponding event
     *
     * Events:
     * [RegionsChangedEvent],
     * [RegionsEnteredEvent],
     * [RegionsLeftEvent],
     * [RegionEnteredEvent],
     * [RegionLeftEvent]
     */
    override fun onCrossBoundary(
            player: LocalPlayer,
            from: Location?,
            to: Location?,
            toSet: ApplicableRegionSet?,
            entered: Set<ProtectedRegion?>,
            left: Set<ProtectedRegion?>,
            moveType: MoveType?
    ): Boolean {
        val regionsChange = RegionsChangedEvent(player.uniqueId, left, entered)
        eventBus.post(regionsChange)

        if (regionsChange.isCancelled) {
            return false
        }

        val regionsEntered = RegionsEnteredEvent(player.uniqueId, entered)
        eventBus.post(regionsEntered)

        if (regionsEntered.isCancelled) {
            return false
        }

        val regionsLeft = RegionsLeftEvent(player.uniqueId, left)
        eventBus.post(regionsLeft)

        if (regionsLeft.isCancelled) {
            return false
        }

        for (region in entered) {
            val regionEntered = RegionEnteredEvent(player.uniqueId, region)
            eventBus.post(regionEntered)

            if (regionEntered.isCancelled) {
                return false
            }
        }

        for (region in left) {
            val regionLeft = RegionLeftEvent(player.uniqueId, region)
            eventBus.post(regionLeft)

            if (regionLeft.isCancelled) {
                return false
            }
        }

        return true
    }

    companion object {
        private val plugin = JavaPlugin.getPlugin(FrozenJoinSpigot::class.java)
        private val eventBus = plugin.listenerRegistration.eventBus

        val factory = Factory(eventBus)
    }
}