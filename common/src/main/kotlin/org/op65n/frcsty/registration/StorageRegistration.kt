package org.op65n.frcsty.registration

import org.op65n.frcsty.model.Format
import org.op65n.frcsty.model.MOTD
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class StorageRegistration {

    private val formats: MutableMap<String, Format> = mutableMapOf()
    private val motds: MutableMap<String, MOTD> = mutableMapOf()

    fun initializeFormats(path: String) {
        val file = File(path)
        val configuration = YamlConfiguration.loadConfiguration(file)

        val section = configuration.getConfigurationSection("formats")
                ?: error("File section 'formats' has not been found within file at path '$path")

        for (format in section.getKeys(false)) {
            val formatSection = section.getConfigurationSection(format) ?: continue
            val executionSection = formatSection.getConfigurationSection("execution") ?: continue
            val execution: MutableMap<String, List<String>> = mutableMapOf()

            for (executor in executionSection.getKeys(false)) {
                execution[executor] = executionSection.getStringList(executor)
            }
            formats[format] = Format(
                    formatSection.getString("permission"),
                    formatSection.getInt("priority"),
                    execution
            )
        }
    }

    fun initializeMotds(path: String) {
        val file = File(path)
        val configuration = YamlConfiguration.loadConfiguration(file)

        val section = configuration.getConfigurationSection("motds")
                ?: error("File section 'motds' has not been found within file at path '$path'")

        for (motd in section.getKeys(false)) {
            val motdSection = section.getConfigurationSection(motd) ?: continue

            motds[motd] = MOTD(
                    motdSection.getString("permission"),
                    motdSection.getInt("priority"),
                    motdSection.getStringList("actions")
            )
        }
    }
}