package fr.astrantv.justClaim.commandHandler.commands.town.member.role.remove;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class remove extends SubCommand {

    public remove(CommandSender sender){
        super(sender);
        name = "remove";
        desc = "A command to remove a Role from a Member";
    }

    @Override
    public void exe(String[] args) {

    }

}
