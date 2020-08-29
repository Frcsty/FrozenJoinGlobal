package com.github.frcsty.listener.base

import com.github.frcsty.event.worldguard.*
import com.sk89q.worldedit.util.Location
import com.sk89q.worldguard.LocalPlayer
import com.sk89q.worldguard.protection.ApplicableRegionSet
import com.sk89q.worldguard.protection.regions.ProtectedRegion
import com.sk89q.worldguard.session.MoveType
import com.sk89q.worldguard.session.Session
import com.sk89q.worldguard.session.handler.Handler
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.plugin.PluginManager

class RegionListener(session: Session?) :
    Handler(session), Listener {

    private val manager: PluginManager = Bukkit.getPluginManager()

    class Factory : Handler.Factory<RegionListener>() {
        override fun create(session: Session): RegionListener {
            return RegionListener(session)
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
        manager.callEvent(regionsChange)

        if (regionsChange.isCancelled) {
            return false
        }

        val regionsEntered = RegionsEnteredEvent(player.uniqueId, entered)
        manager.callEvent(regionsEntered)

        if (regionsEntered.isCancelled) {
            return false
        }

        val regionsLeft = RegionsLeftEvent(player.uniqueId, left)
        manager.callEvent(regionsLeft)

        if (regionsLeft.isCancelled) {
            return false
        }

        for (region in entered) {
            val regionEntered = RegionEnteredEvent(player.uniqueId, region)
            manager.callEvent(regionEntered)

            if (regionEntered.isCancelled) {
                return false
            }
        }

        for (region in left) {
            val regionLeft = RegionLeftEvent(player.uniqueId, region)
            manager.callEvent(regionLeft)

            if (regionLeft.isCancelled) {
                return false
            }
        }

        return true
    }

    companion object {
        val factory = Factory()
    }
}