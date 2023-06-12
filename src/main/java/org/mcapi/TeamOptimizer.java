package org.mcapi;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TeamOptimizer
  extends JavaPlugin
{
  public void start()
  {
      getServer().getPluginManager().registerEvents(new optimizer(), this);
  }
}
