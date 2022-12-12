package fr.astrantv.justClaim.commandHandler.commands.town.rule.add.power.noBetween;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class noBetween extends SubCommand {
    public noBetween(CommandSender sender) {
        super(sender);
        name = "noBetween";
        desc = "A command to add a Town's Rule power interval to exclude";
    }

    @Override
    public void exe(String[] args) {

    }

}
