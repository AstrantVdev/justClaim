package fr.astrantv.justClaim.commandHandler.commands.town.rule.add.power;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.power.no.no;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.power.noBetween.noBetween;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.power.yes.yes;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.power.yesBetween.yesBetween;
import org.bukkit.command.CommandSender;

public class power extends SubCommand {

    public power(CommandSender sender) {
        super(sender);
        name = "power";
        desc = "A command to add an item to a Town's Rule's Power property";

        subCommands.add(new yes(sender));
        subCommands.add(new no(sender));
        subCommands.add(new yesBetween(sender));
        subCommands.add(new noBetween(sender));

    }

    @Override
    public void exe(String[] args) {

    }
}
