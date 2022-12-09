package fr.astrantv.justClaim.commandHandler.commands.town.plot;

import fr.astrantv.justClaim.commandHandler.commands.town.plot.add.add;
import fr.astrantv.justClaim.commandHandler.commands.town.plot.remove.remove;
import org.bukkit.command.CommandSender;
import fr.astrantv.justClaim.commandHandler.SubCommand;

public class plot extends SubCommand {

    public plot(CommandSender sender) {
        super(sender);
        name = "plot";
        desc = "A command to manage a plot";

        subCommands.add(new add(sender));
        subCommands.add(new remove(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
