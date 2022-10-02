package org.op65n.frcsty.listener.spigot

import org.op65n.frcsty.event.spigot.FrozenSwitchWorldEvent
import org.op65n.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object FrozenSwitchWorldListener : ActionListener {

    @Subscribe
    fun onFrozenSwitchWorld(event: FrozenSwitchWorldEvent) {
        println("Executed @${event.eventName}")
    }
}