package fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.entityPerm.activeTypeYes;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class activeTypeYes extends SubCommand {
    public activeTypeYes(CommandSender sender) {
        super(sender);
        name = "activeTypeYes";
        desc = "A command to remove a Town's Rule entityPerm included activeType";
    }

    @Override
    public void exe(String[] args) {

    }

}
