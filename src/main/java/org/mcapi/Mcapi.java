package org.mcapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class Mcapi extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new optimizer(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
