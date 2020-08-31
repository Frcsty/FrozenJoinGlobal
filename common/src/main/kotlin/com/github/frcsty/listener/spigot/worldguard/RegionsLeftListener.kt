package com.github.frcsty.listener.spigot.worldguard

import com.github.frcsty.event.spigot.worldguard.RegionsLeftEvent
import com.github.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object RegionsLeftListener : ActionListener {

    @Subscribe
    fun onRegionsLeft(event: RegionsLeftEvent) {
        println("Executed @${event.eventName}")
    }
}