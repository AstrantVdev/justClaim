package fr.astrantv.justClaim.commandHandler.commands.town.role.add.perm;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class perm extends SubCommand {
    public perm(CommandSender sender) {
        super(sender);
        name = "perm";
        desc = "A command to add a Town's Role Perm";
    }

    @Override
    public void exe(String[] args) {

    }

}
