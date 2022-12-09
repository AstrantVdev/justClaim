package fr.astrantv.justClaim;

import fr.astrantv.justClaim.db.Member;
import fr.astrantv.justClaim.db.Plot;
import fr.astrantv.justClaim.db.Town;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityInteractEvent;

public class PlotProtectionListener implements Listener{

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e){
        Location loc = e.getBlock().getLocation();
        Plot plot = new Plot(loc);

        if(plot.IsRegistered()){
            Player p = e.getPlayer();
            Member m = new Member(p.getUniqueId());
            Town plotTown = plot.GetTown();

            if(plotTown.getMembersUUID().contains(m.getUuid())){

            }

            e.setCancelled(true);

        }

    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e){
        Location loc = e.getBlock().getLocation();
        Plot plot = new Plot(loc);

        if(plot.IsRegistered()){

        }

    }

    @EventHandler
    public void onEntityInteractEvent(EntityInteractEvent e){
        Location loc = e.getBlock().getLocation();
        Plot plot = new Plot(loc);

        if(plot.IsRegistered()){

        }

    }

    @EventHandler
    public void onBlockPhysicsEvent(BlockPhysicsEvent e){
        Location loc = e.getSourceBlock().getLocation();
        Plot plot = new Plot(loc);

        if(plot.IsRegistered()){

        }

    }

    @EventHandler
    public void onBlockFromToEvent(BlockFromToEvent e){
        Location loc = e.getToBlock().getLocation();
        Plot plot = new Plot(loc);

        if(plot.IsRegistered()){

        }

    }

    @EventHandler
    public void onBlockGrowEvent(BlockGrowEvent e){
        Location loc = e.getBlock().getLocation();
        Plot plot = new Plot(loc);

        if(plot.IsRegistered()){

        }

    }

    @EventHandler
    public void onBlockFormEvent(BlockFormEvent e){
        Location loc = e.getBlock().getLocation();
        Plot plot = new Plot(loc);

        if(plot.IsRegistered()){

        }

    }

    @EventHandler
    public void onBlockFadeEvent(BlockFadeEvent e){
        Location loc = e.getBlock().getLocation();
        Plot plot = new Plot(loc);

        if(plot.IsRegistered()){

        }

    }

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e){
        Location loc = e.getEntity().getLocation();
        Plot plot = new Plot(loc);

        if(plot.IsRegistered()){

        }

    }

    @EventHandler
    public void onEntityExplodeEvent (BlockExplodeEvent e){
        Location loc = e.getBlock().getLocation();
        Plot plot = new Plot(loc);

        if(plot.IsRegistered()){

        }

    }

}
