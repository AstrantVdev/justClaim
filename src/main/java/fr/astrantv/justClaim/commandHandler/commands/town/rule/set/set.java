package fr.astrantv.justClaim.commandHandler.commands.town.rule.set;

import fr.astrantv.justClaim.commandHandler.SubCommand;

public class set extends SubCommand {
    public set(org.bukkit.command.CommandSender sender) {
        super(sender);
        name = "set";
        desc = "A command to set a Town's Role's property";
    }

    @Override
    public void exe(String[] args) {

    }

}
