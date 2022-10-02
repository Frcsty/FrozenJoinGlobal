package org.op65n.frcsty.listener.bungee

import org.op65n.frcsty.event.bungee.FrozenPostLoginEvent
import org.op65n.frcsty.listener.ActionListener
import com.google.common.eventbus.Subscribe

object FrozenPostLoginListener : ActionListener {

    @Subscribe
    fun onFrozenPostLogin(event: FrozenPostLoginEvent) {
        println("Executed @FrozenPostLoginEvent")
    }
}