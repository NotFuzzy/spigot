package org.essentials.antiexploit;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
{
  public void start()
  {
    getServer().getPluginManager().registerEvents(new EventListener(), this);
  }
}
