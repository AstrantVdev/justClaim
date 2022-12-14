package fr.astrantv.justClaim.commandHandler.commands.town.rule.add;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.blockPerm.blockPerm;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.entityPerm.entityPerm;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.power.power;

public class add extends SubCommand {
    public add(org.bukkit.command.CommandSender sender) {
        super(sender);
        name = "add";
        desc = "A command to add an item to a Town's Rule's property";

        addSub(new blockPerm(sender));
        addSub(new entityPerm(sender));
        addSub(new power(sender));
    }

    @Override
    public void exe(String[] args) {

    }
}
