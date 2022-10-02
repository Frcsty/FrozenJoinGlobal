package org.op65n.frcsty.listener.spigot.worldguard

import org.op65n.frcsty.event.spigot.worldguard.RegionLeftEvent
import org.op65n.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object RegionLeftListener : ActionListener {

    @Subscribe
    fun onRegionLeave(event: RegionLeftEvent) {
        println("Executed @${event.eventName}")
    }
}