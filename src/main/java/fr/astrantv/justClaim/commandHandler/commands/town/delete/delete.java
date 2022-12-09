package fr.astrantv.justClaim.commandHandler.commands.town.delete;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class delete extends SubCommand {

    public delete(CommandSender sender) {
        super(sender);
        name = "delete";
        desc = "A command to delete a town";
    }

    @Override
    public void exe(String[] args) {

    }

}
