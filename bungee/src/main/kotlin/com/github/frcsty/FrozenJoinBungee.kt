package com.github.frcsty

import com.github.frcsty.handle.ListenerHandler
import com.github.frcsty.registration.ListenerRegistration
import com.github.frcsty.registration.StorageRegistration
import net.md_5.bungee.api.plugin.Plugin

class FrozenJoinBungee : Plugin() {

    private val listenerRegistration = ListenerRegistration()
    private val storageRegistration = StorageRegistration()

    override fun onEnable() {
        listenerRegistration.register(false)

        storageRegistration.initializeFormats("$dataFolder/formats.yml")
        storageRegistration.initializeMotds("$dataFolder/motds.yml")

        ListenerHandler(this, listenerRegistration.eventBus).register()
    }

}