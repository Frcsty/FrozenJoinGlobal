package org.op65n.frcsty.listener.spigot

import org.op65n.frcsty.event.spigot.FrozenJoinEvent
import org.op65n.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object FrozenJoinListener : ActionListener {

    @Subscribe
    fun onEvent(event: FrozenJoinEvent) {
        println("Executed @${event.eventName}")
    }

}