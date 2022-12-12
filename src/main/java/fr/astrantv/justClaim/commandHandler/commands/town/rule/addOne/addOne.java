package fr.astrantv.justClaim.commandHandler.commands.town.rule.addOne;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class addOne extends SubCommand {

    public addOne(CommandSender sender) {
        super(sender);
        name = "addOne";
        desc = "A command to add a Rule to a Town";
    }

    @Override
    public void exe(String[] args) {

    }

}
