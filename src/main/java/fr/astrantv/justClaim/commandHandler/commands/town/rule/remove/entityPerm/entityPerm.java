package fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.entityPerm;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.entityPerm.activeTypeNo.activeTypeNo;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.entityPerm.activeTypeYes.activeTypeYes;
import org.bukkit.command.CommandSender;

public class entityPerm extends SubCommand {
    public entityPerm(CommandSender sender) {
        super(sender);
        name = "entityPerm";
        desc = "A command to remove an item from a Town's Rule entityPerm property";

        subCommands.add(new activeTypeNo(sender));
        subCommands.add(new activeTypeYes(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
