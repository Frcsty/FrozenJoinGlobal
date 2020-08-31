package com.github.frcsty.listener.bungee

import com.github.frcsty.event.bungee.FrozenHandshakeEvent
import com.github.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object FrozenHandshakeListener : ActionListener {

    @Subscribe
    fun onFrozenHandshake(event: FrozenHandshakeEvent) {
        println("Executed @FrozenHandshakeEvent")
    }
}