package fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.power.yes;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class yes extends SubCommand {
    public yes(CommandSender sender) {
        super(sender);
        name = "yes";
        desc = "A command to remove a Town's Rule included power value";
    }

    @Override
    public void exe(String[] args) {

    }

}
