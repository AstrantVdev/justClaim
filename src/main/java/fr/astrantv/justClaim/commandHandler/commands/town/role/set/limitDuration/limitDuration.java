package fr.astrantv.justClaim.commandHandler.commands.town.role.set.limitDuration;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class limitDuration extends SubCommand {
    public limitDuration(CommandSender sender) {
        super(sender);
        name = "limitDuration";
        desc = "A command to set a Town's Role limitDuration";
    }

    @Override
    public void exe(String[] args) {

    }

}
