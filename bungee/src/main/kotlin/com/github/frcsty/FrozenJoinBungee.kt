package com.github.frcsty

import com.github.frcsty.handle.ListenerHandler
import net.md_5.bungee.api.plugin.Plugin

class FrozenJoinBungee : Plugin() {

    val registration = ListenerRegistration()

    override fun onEnable() {
        registration.register()

        ListenerHandler(this, registration.eventBus).register()
    }

    override fun onDisable() {

    }
}