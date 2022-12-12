package fr.astrantv.justClaim.commandHandler.commands.town.rule.add.power.yes;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class yes extends SubCommand {
    public yes(CommandSender sender) {
        super(sender);
        name = "yes";
        desc = "A command to add a Town's Rule power value to include";
    }

    @Override
    public void exe(String[] args) {

    }

}
