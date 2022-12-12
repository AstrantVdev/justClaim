package fr.astrantv.justClaim.commandHandler.commands.town.member.role;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.member.removeOne.removeOne;
import fr.astrantv.justClaim.commandHandler.commands.town.member.role.add.add;
import org.bukkit.command.CommandSender;

public class role extends SubCommand {

    public role(CommandSender sender) {
        super(sender);
        name = "role";
        desc = "A command to manage Roles from a Member";

        subCommands.add(new add(sender));
        subCommands.add(new removeOne(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
