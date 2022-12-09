package fr.astrantv.justClaim.commandHandler.commands.town.subPlot.rule;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.rule.add.add;
import fr.astrantv.justClaim.commandHandler.commands.town.subPlot.rule.remove.remove;
import org.bukkit.command.CommandSender;

public class rule extends SubCommand {

    public rule(CommandSender sender) {
        super(sender);
        name = "rule";
        desc = "A command to manage the Rules of a SubPlot";

        subCommands.add(new add(sender));
        subCommands.add(new remove(sender));
    }

    @Override
    public void exe(String[] args) {

    }

}
