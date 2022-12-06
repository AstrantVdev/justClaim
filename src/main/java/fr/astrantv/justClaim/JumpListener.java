package fr.astrantv.justClaim;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashMap;

import static fr.astrantv.justClaim.Main.plugin;

public class JumpListener implements Listener {
    HashMap<Player, Integer> players = new HashMap();

    @EventHandler
    public void setFly(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        players.put(p, 3);
        p.setAllowFlight(true);
        p.setFlying(false);

    }

    @EventHandler
    public void on(PlayerToggleFlightEvent e) {
        e.setCancelled(true);

        Player p = e.getPlayer();
        int doubleJumps = players.get(p);

        if (p.getGameMode() != GameMode.CREATIVE && p.getGameMode() != GameMode.SPECTATOR && !p.isFlying()) {
            p.setAllowFlight(false);
            p.setFlying(false);

            if(doubleJumps > 0){
                p.setVelocity(e.getPlayer().getLocation().getDirection().setY(1));

                players.replace(p, doubleJumps-1);

                BukkitScheduler scheduler = Bukkit.getScheduler();
                (scheduler).runTaskLater(plugin, () -> {
                    p.setAllowFlight(true);

                }, 20 * 4 );

            }

        }

    }

}
