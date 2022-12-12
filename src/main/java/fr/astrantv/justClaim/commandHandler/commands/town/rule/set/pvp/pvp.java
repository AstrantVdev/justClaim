package fr.astrantv.justClaim.commandHandler.commands.town.rule.set.pvp;

import fr.astrantv.justClaim.commandHandler.SubCommand;

public class pvp extends SubCommand {
    public pvp(org.bukkit.command.CommandSender sender) {
        super(sender);
        name = "pvp";
        desc = "A command to set a Town's Role's pvp";
    }

    @Override
    public void exe(String[] args) {

    }

}
