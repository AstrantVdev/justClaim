package fr.astrantv.justClaim.handler.commands.town.plot;

import fr.astrantv.justClaim.handler.commands.town.plot.claim.claim;
import org.bukkit.command.CommandSender;
import fr.astrantv.justClaim.handler.SubCommand;

public class plot extends SubCommand {

    public plot(CommandSender sender) {
        super(sender);
        name = "plot";
        desc = "A command to manage a plot";

        subCommands.add(new claim(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
