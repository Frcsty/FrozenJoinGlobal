package com.github.frcsty.listener.spigot.worldguard

import com.github.frcsty.event.spigot.worldguard.RegionsLeftEvent
import com.google.common.eventbus.Subscribe

object RegionsLeftListener {

    @Subscribe
    fun onRegionsLeft(event: RegionsLeftEvent) {
        println("Executed @${event.eventName}")
    }
}