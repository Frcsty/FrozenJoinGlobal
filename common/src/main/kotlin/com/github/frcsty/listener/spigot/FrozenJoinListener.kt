package com.github.frcsty.listener.spigot

import com.github.frcsty.event.spigot.FrozenJoinEvent
import com.google.common.eventbus.Subscribe

object FrozenJoinListener {

    @Subscribe
    fun onFrozenJoin(event: FrozenJoinEvent) {
        println("Executed @${event.eventName}")
    }
}