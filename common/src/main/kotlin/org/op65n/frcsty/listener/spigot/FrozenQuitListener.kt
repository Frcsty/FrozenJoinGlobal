package org.op65n.frcsty.listener.spigot

import org.op65n.frcsty.event.spigot.FrozenQuitEvent
import org.op65n.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object FrozenQuitListener : ActionListener {

    @Subscribe
    fun onFrozenQuit(event: FrozenQuitEvent) {
        println("Executed @${event.eventName}")
    }
}