package fr.astrantv.justClaim.commandHandler.commands.town.role.add;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.role.add.perm.perm;
import org.bukkit.command.CommandSender;

public class add extends SubCommand {
    public add(CommandSender sender) {
        super(sender);
        name = "add";
        desc = "A command to add an item to a Town's Role's property";

        addSub(new perm(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
