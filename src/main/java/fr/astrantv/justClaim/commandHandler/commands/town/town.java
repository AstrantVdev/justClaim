package fr.astrantv.justClaim.commandHandler.commands.town;
import fr.astrantv.justClaim.commandHandler.commands.town.create.create;
import fr.astrantv.justClaim.commandHandler.commands.town.delete.delete;
import fr.astrantv.justClaim.commandHandler.commands.town.money.money;
import fr.astrantv.justClaim.commandHandler.commands.town.plot.plot;
import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;

public class town extends SubCommand {

    public town(CommandSender sender) {
        super(sender);
        name = "town";
        desc = "A command to manage a Town";

        subCommands.add(new create(sender));
        subCommands.add(new plot(sender));
        subCommands.add(new delete(sender));
        subCommands.add(new money(sender));

    }

    @Override
    public void exe(String[] args) {

    }

}
