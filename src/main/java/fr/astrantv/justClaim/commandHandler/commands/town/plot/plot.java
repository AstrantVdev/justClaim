package fr.astrantv.justClaim.commandHandler.commands.town.plot;

import fr.astrantv.justClaim.commandHandler.commands.town.plot.addOne.addOne;
import fr.astrantv.justClaim.commandHandler.commands.town.plot.removeOne.removeOne;
import org.bukkit.command.CommandSender;
import fr.astrantv.justClaim.commandHandler.SubCommand;

public class plot extends SubCommand {

    public plot(CommandSender sender) {
        super(sender);
        name = "plot";
        desc = "A command to manage a plot";

        addSub(new addOne(sender));
        addSub(new removeOne(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
