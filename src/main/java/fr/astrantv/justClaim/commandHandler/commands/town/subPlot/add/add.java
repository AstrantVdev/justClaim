package fr.astrantv.justClaim.commandHandler.commands.town.subPlot.add;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class add extends SubCommand {

        public add(CommandSender sender) {
            super(sender);
            name = "add";
            desc = "A command to add a subPlot";
        }

        @Override
        public void exe(String[] args) {

        }

}
