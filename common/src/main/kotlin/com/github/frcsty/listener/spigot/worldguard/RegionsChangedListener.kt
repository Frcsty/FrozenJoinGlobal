package com.github.frcsty.listener.spigot.worldguard

import com.github.frcsty.event.spigot.worldguard.RegionsChangedEvent
import com.google.common.eventbus.Subscribe

object RegionsChangedListener {

    @Subscribe
    fun onRegionsChanged(event: RegionsChangedEvent) {
        println("Executed @${event.eventName}")
    }
}