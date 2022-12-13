package fr.astrantv.justClaim.commandHandler.commands.town.member.addOne;

import fr.astrantv.justClaim.commandHandler.Arg;
import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class addOne extends SubCommand {

    public addOne(CommandSender sender) {
        super(sender);
        name = "addOne";
        desc = "A command to add a Member to a Town";

        addArg(new Arg("playerNames")
                .setMinChr(3)
                .addChoice(Bukkit.getOnlinePlayers()
                        .stream()
                        .map(player -> player.getName())
                        .toArray(String[]::new)));
    }

    @Override
    public void exe(String[] args) {

    }

}
