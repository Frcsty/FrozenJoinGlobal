package org.op65n.frcsty

interface Registerable {

    fun identifier(): String = ""
    fun register()

}