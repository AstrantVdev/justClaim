package fr.astrantv.justClaim.commandHandler.commands.color.sheep;

import fr.astrantv.justClaim.commandHandler.Arg;
import fr.astrantv.justClaim.commandHandler.commands.color.color;
import fr.astrantv.justClaim.utils.enums;
import org.bukkit.DyeColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import fr.astrantv.justClaim.commandHandler.SubCommand;

import java.util.ArrayList;
import java.util.EnumSet;

public class sheep extends SubCommand {

    public sheep(CommandSender sender){
        super(sender);
        name = "sheep";
        desc = "Foxy ! Give a colored sheep...";

        Arg colorArg = new Arg();
        colorArg.required = true;
        colorArg.choices = new ArrayList<>(EnumSet.allOf(color.COLORS.class));
        args.add(colorArg);

    }

    @Override
    public void exe(String[] args) {
        Player player = (Player) sender;
        DyeColor dye = DyeColor.BLACK;

        for(enums.COLORS color : enums.COLORS.values()){
            String colorStr = color.toString();

            if(args[0].equalsIgnoreCase(colorStr)){
                dye = color.color;
                break;

            }

        }

        Sheep s = (Sheep) player.getWorld().spawnEntity(player.getLocation(), EntityType.SHEEP);
        s.setColor(dye);

    }

}
