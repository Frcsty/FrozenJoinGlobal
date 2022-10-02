package org.op65n.frcsty.listener.spigot.worldguard

import org.op65n.frcsty.event.spigot.worldguard.RegionsLeftEvent
import org.op65n.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object RegionsLeftListener : ActionListener {

    @Subscribe
    fun onRegionsLeft(event: RegionsLeftEvent) {
        println("Executed @${event.eventName}")
    }
}