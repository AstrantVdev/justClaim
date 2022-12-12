package fr.astrantv.justClaim.commandHandler.commands.town.role.set.limit;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class limit extends SubCommand {
    public limit(CommandSender sender) {
        super(sender);
        name = "limit";
        desc = "A command to set a Town's Role Limit";
    }

    @Override
    public void exe(String[] args) {

    }

}
