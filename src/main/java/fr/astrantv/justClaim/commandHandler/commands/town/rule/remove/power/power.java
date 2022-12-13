package fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.power;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.power.no.no;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.power.noBetween.noBetween;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.power.yes.yes;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.remove.power.yesBetween.yesBetween;
import org.bukkit.command.CommandSender;

public class power extends SubCommand {
    public power(CommandSender sender) {
        super(sender);
        name = "power";
        desc = "A command to remove an item from a Town's Rule's Power property";

        addSub(new yes(sender));
        addSub(new no(sender));
        addSub(new yesBetween(sender));
        addSub(new noBetween(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
