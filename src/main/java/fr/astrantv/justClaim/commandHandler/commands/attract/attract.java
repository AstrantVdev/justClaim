package fr.astrantv.justClaim.commandHandler.commands.attract;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.util.Vector;

import java.util.List;

public class attract extends SubCommand {

    public attract(CommandSender sender){
        super(sender);
        name = "attract";
        desc = "Foxy ! atract everythiiing ! ow";

    }

    @Override
    public void exe(String[] args) {
        Player player = (Player) sender;
        Location pLoc = player.getLocation();

        List<Entity> entities = player.getNearbyEntities(20,20,20);

        for(Entity entity : entities){
            Location eLoc = entity.getLocation();

            Vector vec = new Vector(pLoc.getX()-eLoc.getX(),pLoc.getY()-eLoc.getY(),pLoc.getZ()-eLoc.getZ());

            vec = entity.getVelocity().add(vec).normalize();

            entity.setVelocity(vec.multiply(-5));

        }

    }

}
