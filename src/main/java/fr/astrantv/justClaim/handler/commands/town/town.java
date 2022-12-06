package fr.astrantv.justClaim.handler.commands.town;
import fr.astrantv.justClaim.handler.commands.town.create.create;
import fr.astrantv.justClaim.handler.commands.town.plot.plot;
import fr.astrantv.justClaim.handler.SubCommand;
import org.bukkit.command.CommandSender;

public class town extends SubCommand {

    public town(CommandSender sender) {
        super(sender);
        name = "town";
        desc = "A command to manage a town";

        subCommands.add(new create(sender));
        subCommands.add(new plot(sender));

    }

    @Override
    public void exe(String[] args) {

    }

}
