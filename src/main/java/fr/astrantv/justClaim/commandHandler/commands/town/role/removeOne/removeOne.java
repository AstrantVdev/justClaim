package fr.astrantv.justClaim.commandHandler.commands.town.role.removeOne;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class removeOne extends SubCommand {
    public removeOne(CommandSender sender) {
        super(sender);
        name = "removeOne";
        desc = "A command to remove a Role from a Town";
    }

    @Override
    public void exe(String[] args) {

    }
}
