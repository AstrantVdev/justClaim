package fr.astrantv.justClaim.commandHandler.commands.town.money;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.money.add.add;
import fr.astrantv.justClaim.commandHandler.commands.town.money.remove.remove;
import org.bukkit.command.CommandSender;

public class money extends SubCommand {

    public money(CommandSender sender){
        super(sender);
        name = "money";
        desc = "A command to manage Money in a Town";

        subCommands.add(new add(sender));
        subCommands.add(new remove(sender));

    }

    @Override
    public void exe(String[] args) {

    }

}
