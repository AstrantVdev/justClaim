package fr.astrantv.justClaim.commandHandler.commands.town.rule.add.entityPerm.activeType;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class activeTypeYes extends SubCommand {
    public activeTypeYes(CommandSender sender) {
        super(sender);
        name = "activeType";
        desc = "A command to add a Town's Rule entityPerm included activeType";
    }

    @Override
    public void exe(String[] args) {

    }
}
