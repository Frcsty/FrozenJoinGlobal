package com.github.frcsty.listener.bungee

import com.github.frcsty.event.bungee.FrozenPostLoginEvent
import com.google.common.eventbus.Subscribe

object FrozenPostLoginListener {

    @Subscribe
    fun onFrozenPostLogin(event: FrozenPostLoginEvent) {
        println("Executed @FrozenPostLoginEvent")
    }
}