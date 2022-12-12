package fr.astrantv.justClaim.commandHandler.commands.town.rule.add.entityPerm;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.entityPerm.activeType.activeTypeYes;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.entityPerm.activeTypeNo.activeTypeNo;
import org.bukkit.command.CommandSender;

public class entityPerm extends SubCommand {
    public entityPerm(CommandSender sender) {
        super(sender);
        name = "entityPerm";
        desc = "A command to add an item to a Town's Rule's EntityPerm property";

        subCommands.add(new activeTypeYes(sender));
        subCommands.add(new activeTypeNo(sender));
    }

    @Override
    public void exe(String[] args) {

    }
}
