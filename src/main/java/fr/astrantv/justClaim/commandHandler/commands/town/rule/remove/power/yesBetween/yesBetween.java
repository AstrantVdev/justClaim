package fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.power.yesBetween;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class yesBetween extends SubCommand {
    public yesBetween(CommandSender sender) {
        super(sender);
        name = "yesBetween";
        desc = "A command to remove a Town's Rule included power interval";
    }

    @Override
    public void exe(String[] args) {

    }

}
