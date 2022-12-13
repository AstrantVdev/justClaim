package fr.astrantv.justClaim.commandHandler.commands.town.role.set;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.role.set.limit.limit;
import fr.astrantv.justClaim.commandHandler.commands.town.role.set.limitDuration.limitDuration;
import org.bukkit.command.CommandSender;

public class set extends SubCommand {
    public set(CommandSender sender) {
        super(sender);
        name = "set";
        desc = "A command to set a Town's Role property";

        addSub(new limit(sender));
        addSub(new limitDuration(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
