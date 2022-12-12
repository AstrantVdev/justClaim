package fr.astrantv.justClaim.commandHandler.commands.town.rule.add.entityPerm.activeTypeNo;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class activeTypeNo extends SubCommand {
    public activeTypeNo(CommandSender sender) {
        super(sender);
        name = "activeTypeNo";
        desc = "A command to add a Town's Rule entityPerm excluded activeType";
    }

    @Override
    public void exe(String[] args) {

    }

}
