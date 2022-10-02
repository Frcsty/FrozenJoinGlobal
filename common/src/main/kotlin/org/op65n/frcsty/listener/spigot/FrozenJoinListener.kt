package com.github.frcsty.listener.spigot

import org.op65n.frcsty.event.spigot.FrozenJoinEvent
import com.github.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object FrozenJoinListener : ActionListener {

    @Subscribe
    fun onEvent(event: FrozenJoinEvent) {
        println("Executed @${event.eventName}")
    }

}