package fr.astrantv.justClaim.commandHandler.commands.town.rule.remove;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.blockPerm.blockPerm;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.entityPerm.entityPerm;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.power.power;

public class remove extends SubCommand {
    public remove(org.bukkit.command.CommandSender sender) {
        super(sender);
        name = "remove";
        desc = "A command to remove an item from a Town's Rule's property";

        addSub(new blockPerm(sender));
        addSub(new entityPerm(sender));
        addSub(new power(sender));

    }

    @Override
    public void exe(String[] args) {

    }

}
