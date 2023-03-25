package org.silvius.antiautofishing;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiAutoFishing extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BlockListeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
