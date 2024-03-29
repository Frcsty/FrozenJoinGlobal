package org.op65n.frcsty.listener.spigot.worldguard

import org.op65n.frcsty.event.spigot.worldguard.RegionsEnteredEvent
import org.op65n.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object RegionsEnteredListener : ActionListener {

    @Subscribe
    fun onRegionsEntered(event: RegionsEnteredEvent) {
        println("Executed @${event.eventName}")
    }
}