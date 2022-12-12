package fr.astrantv.justClaim.commandHandler.commands.town.rule.add.power.yesBetween;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class yesBetween extends SubCommand {

    public yesBetween(CommandSender sender) {
        super(sender);
        name = "yesBetween";
        desc = "A command to add a Town's Rule power interval to include";
    }

    @Override
    public void exe(String[] args) {

    }
}
