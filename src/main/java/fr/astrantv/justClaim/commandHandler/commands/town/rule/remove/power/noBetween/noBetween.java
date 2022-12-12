package fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.power.noBetween;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class noBetween extends SubCommand {
    public noBetween(CommandSender sender) {
        super(sender);
        name = "noBetween";
        desc = "A command to remove a Town's Rule excluded power interval";
    }

    @Override
    public void exe(String[] args) {

    }

}
