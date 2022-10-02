package org.op65n.frcsty.listener.spigot.worldguard

import org.op65n.frcsty.event.spigot.worldguard.RegionsChangedEvent
import org.op65n.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object RegionsChangedListener : ActionListener {

    @Subscribe
    fun onRegionsChanged(event: RegionsChangedEvent) {
        println("Executed @${event.eventName}")
    }
}