package fr.astrantv.justClaim.commandHandler.commands.town.rule.add.blockPerm;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.blockPerm.no.no;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.blockPerm.yes.yes;
import org.bukkit.command.CommandSender;

public class blockPerm extends SubCommand {

    public blockPerm(CommandSender sender) {
        super(sender);
        name = "blockPerm";
        desc = "A command to add an item to a Town's Rule's BlockPerm property";

        subCommands.add(new yes(sender));
        subCommands.add(new no(sender));
    }

    @Override
    public void exe(String[] args) {


    }

}
