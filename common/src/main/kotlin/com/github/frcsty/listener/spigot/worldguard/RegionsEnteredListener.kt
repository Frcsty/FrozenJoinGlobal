package com.github.frcsty.listener.spigot.worldguard

import com.github.frcsty.event.spigot.worldguard.RegionsEnteredEvent
import com.google.common.eventbus.Subscribe

object RegionsEnteredListener {

    @Subscribe
    fun onRegionsEntered(event: RegionsEnteredEvent) {
        println("Executed @${event.eventName}")
    }
}