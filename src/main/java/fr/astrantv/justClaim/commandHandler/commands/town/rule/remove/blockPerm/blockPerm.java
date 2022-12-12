package fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.blockPerm;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.blockPerm.no.no;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.blockPerm.yes.yes;
import org.bukkit.command.CommandSender;

public class blockPerm extends SubCommand {
    public blockPerm(CommandSender sender) {
        super(sender);
        name = "blockPerm";
        desc = "A command to remove a Town's Rule blockPerm";

        subCommands.add(new no(sender));
        subCommands.add(new yes(sender));

    }

    @Override
    public void exe(String[] args) {

    }

}
