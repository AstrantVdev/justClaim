package fr.astrantv.justClaim.commandHandler.commands.town.rule.add.blockPerm.yes;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class yes extends SubCommand {
    public yes(CommandSender sender) {
        super(sender);
        name = "yes";
        desc = "A command to add a Town's Rule blockPerm included material";
    }

    @Override
    public void exe(String[] args) {

    }

}
