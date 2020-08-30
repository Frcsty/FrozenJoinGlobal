package com.github.frcsty.listener.bungee

import com.github.frcsty.event.bungee.FrozenHandshakeEvent
import com.google.common.eventbus.Subscribe

object FrozenHandshakeListener {

    @Subscribe
    fun onFrozenHandshake(event: FrozenHandshakeEvent) {
        println("Executed @FrozenHandshakeEvent")
    }
}