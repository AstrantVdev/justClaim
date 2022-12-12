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

        Arg playerNames = new Arg();
        playerNames.required = true;
        playerNames.minChr = 3;
        Bukkit.getOnlinePlayers().forEach(player -> {
            playerNames.choices.add(player.getName());
        });
        args.add(playerNames);
    }

    @Override
    public void exe(String[] args) {

    }

}
