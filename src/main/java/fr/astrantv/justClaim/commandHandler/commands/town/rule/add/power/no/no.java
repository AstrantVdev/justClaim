package fr.astrantv.justClaim.commandHandler.commands.town.rule.add.power.no;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class no extends SubCommand {
    public no(CommandSender sender) {
        super(sender);
        name = "no";
        desc = "A command to add a Town's Rule power value to exclude";
    }

    @Override
    public void exe(String[] args) {

    }
}
