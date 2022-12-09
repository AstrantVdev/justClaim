package fr.astrantv.justClaim.commandHandler.commands.town.role;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.member.role.add.add;
import fr.astrantv.justClaim.commandHandler.commands.town.role.remove.remove;
import org.bukkit.command.CommandSender;

public class role extends SubCommand {
    public role(CommandSender sender) {
        super(sender);
        name = "role";
        desc = "A command to manage Roles of a Town";

        subCommands.add(new add(sender));
        subCommands.add(new remove(sender));
    }

    @Override
    public void exe(String[] args) {

    }
}
