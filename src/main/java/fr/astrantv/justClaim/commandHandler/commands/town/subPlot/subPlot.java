package fr.astrantv.justClaim.commandHandler.commands.town.subPlot;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.subPlot.add.add;
import fr.astrantv.justClaim.commandHandler.commands.town.subPlot.remove.remove;
import fr.astrantv.justClaim.commandHandler.commands.town.subPlot.rule.rule;
import org.bukkit.command.CommandSender;

public class subPlot extends SubCommand {

    public subPlot(CommandSender sender) {
        super(sender);
        name = "subPlot";
        desc = "A command to manage SubPlots of a Town";

        addSub(new add(sender));
        addSub(new remove(sender));
        addSub(new rule(sender));
    }

    @Override
    public void exe(String[] args) {

    }
}
