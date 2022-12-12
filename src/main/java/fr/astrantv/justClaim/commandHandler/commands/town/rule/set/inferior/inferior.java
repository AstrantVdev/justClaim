package fr.astrantv.justClaim.commandHandler.commands.town.rule.set.inferior;

import fr.astrantv.justClaim.commandHandler.SubCommand;

public class inferior extends SubCommand {
    public inferior(org.bukkit.command.CommandSender sender) {
        super(sender);
        name = "inferior";
        desc = "A command to set a Town's Role's inferior";
    }

    @Override
    public void exe(String[] args) {

    }

}
