package com.github.frcsty.listener.spigot.worldguard

import com.github.frcsty.event.spigot.worldguard.RegionsChangedEvent
import com.github.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object RegionsChangedListener : ActionListener {

    @Subscribe
    fun onRegionsChanged(event: RegionsChangedEvent) {
        println("Executed @${event.eventName}")
    }
}