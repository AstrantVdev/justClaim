package fr.astrantv.justClaim.commandHandler.commands.town.rule;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.addOne.addOne;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.removeOne.removeOne;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.set.set;
import org.bukkit.command.CommandSender;

public class rule extends SubCommand {

    public rule(CommandSender sender) {
        super(sender);
        name = "rule";
        desc = "A command to manage the Rules of a Town";

        addSub(new addOne(sender));
        addSub(new removeOne(sender));
        addSub(new set(sender));
        addSub(new addOne(sender));
        addSub(new removeOne(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
