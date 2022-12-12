package fr.astrantv.justClaim.commandHandler.commands.town.rule.set.name;

import fr.astrantv.justClaim.commandHandler.SubCommand;

public class name extends SubCommand {
    public name(org.bukkit.command.CommandSender sender) {
        super(sender);
        name = "name";
        desc = "A command to set a Town's Role's name";
    }

    @Override
    public void exe(String[] args) {

    }

}
