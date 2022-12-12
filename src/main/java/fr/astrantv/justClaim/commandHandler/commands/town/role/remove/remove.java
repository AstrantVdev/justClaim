package fr.astrantv.justClaim.commandHandler.commands.town.role.remove;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.role.remove.perm.perm;
import org.bukkit.command.CommandSender;

public class remove extends SubCommand {
    public remove(CommandSender sender) {
        super(sender);
        name = "remove";
        desc = "A command to remove an item from a Town's Role's property";

        subCommands.add(new perm(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
