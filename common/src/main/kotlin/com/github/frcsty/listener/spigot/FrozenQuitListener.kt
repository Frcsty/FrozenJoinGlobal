package com.github.frcsty.listener.spigot

import com.github.frcsty.event.spigot.FrozenQuitEvent
import com.github.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object FrozenQuitListener : ActionListener {

    @Subscribe
    fun onFrozenQuit(event: FrozenQuitEvent) {
        println("Executed @${event.eventName}")
    }
}