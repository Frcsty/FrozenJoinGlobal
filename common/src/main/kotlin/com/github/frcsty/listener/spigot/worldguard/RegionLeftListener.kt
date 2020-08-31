package com.github.frcsty.listener.spigot.worldguard

import com.github.frcsty.event.spigot.worldguard.RegionLeftEvent
import com.github.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object RegionLeftListener : ActionListener {

    @Subscribe
    fun onRegionLeave(event: RegionLeftEvent) {
        println("Executed @${event.eventName}")
    }
}