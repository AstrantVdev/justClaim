package fr.astrantv.justClaim.commandHandler.commands.town.rule.set.superior;

import fr.astrantv.justClaim.commandHandler.SubCommand;

public class superior extends SubCommand {
    public superior(org.bukkit.command.CommandSender sender) {
        super(sender);
        name = "superior";
        desc = "A command to set a Town's Role's superior";
    }

    @Override
    public void exe(String[] args) {

    }

}
