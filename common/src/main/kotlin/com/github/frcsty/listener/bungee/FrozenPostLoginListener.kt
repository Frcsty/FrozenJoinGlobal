package com.github.frcsty.listener.bungee

import com.github.frcsty.event.bungee.FrozenPostLoginEvent
import com.github.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object FrozenPostLoginListener : ActionListener {

    @Subscribe
    fun onFrozenPostLogin(event: FrozenPostLoginEvent) {
        println("Executed @FrozenPostLoginEvent")
    }
}