package com.github.frcsty.handle

import com.github.frcsty.FrozenJoinSpigot
import com.github.frcsty.Registerable

class FileHandler(private val plugin: FrozenJoinSpigot) : Registerable {

    override fun register() {
        plugin.saveResource("messages.yml", true)
    }
}