package com.github.frcsty.listener.spigot

import com.github.frcsty.event.spigot.FrozenSwitchWorldEvent
import com.google.common.eventbus.Subscribe

object FrozenSwitchWorldListener {

    @Subscribe
    fun onFrozenSwitchWorld(event: FrozenSwitchWorldEvent) {
        println("Executed @${event.eventName}")
    }
}