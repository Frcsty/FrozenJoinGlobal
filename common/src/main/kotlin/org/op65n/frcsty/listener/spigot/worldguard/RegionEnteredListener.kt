package org.op65n.frcsty.listener.spigot.worldguard

import org.op65n.frcsty.event.spigot.worldguard.RegionEnteredEvent
import org.op65n.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object RegionEnteredListener : ActionListener {

    @Subscribe
    fun onRegionEnter(event: RegionEnteredEvent) {
        println("Executed @${event.eventName}")
    }
}