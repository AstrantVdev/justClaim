package fr.astrantv.justClaim.commandHandler.commands.town.rule.remove;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class remove extends SubCommand {

    public remove(CommandSender sender) {
        super(sender);
        name = "remove";
        desc = "A command to remove a Rule from a Town";
    }

    @Override
    public void exe(String[] args) {

    }

}
