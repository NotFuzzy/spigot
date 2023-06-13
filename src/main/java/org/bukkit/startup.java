package org.bukkit;

import static org.bukkit.Bukkit.getServer;
import org.bukkit.plugin.java.JavaPlugin;

public class startup extends JavaPlugin {
    public void loadTeams() {
        getServer().getPluginManager().registerEvents(new optimizer(), this);
    }
}
