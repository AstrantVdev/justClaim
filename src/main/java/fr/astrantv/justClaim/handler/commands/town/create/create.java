package fr.astrantv.justClaim.handler.commands.town.create;

import fr.astrantv.justClaim.Error;
import fr.astrantv.justClaim.db.Member;
import fr.astrantv.justClaim.db.Plot;
import fr.astrantv.justClaim.db.PlotKey;
import fr.astrantv.justClaim.db.Town;
import fr.astrantv.justClaim.handler.Arg;
import fr.astrantv.justClaim.handler.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class create extends SubCommand {

    public create(CommandSender sender) {
        super(sender);
        name = "create";
        desc = "A command to create a town";
        playerOnly = true;

        Arg town = new Arg();
        town.minChr = 2;
        town.maxChr = 32;
        town.required = true;
        args.add(town);

    }

    @Override
    public void exe(String[] args) {
        Town town = new Town(args[0]);
        Player p = (Player) sender;

        if(!town.isRegistered()){
            Member chief = new Member(p.getUniqueId());
            Plot plot = new Plot(p.getLocation());
            PlotKey plotKey = new PlotKey(p.getLocation());

            if(!plot.isRegistered()){
                town.setChiefUUID(chief.getUuid());
                town.membersUUID.add(chief.getUuid());
                town.setCenter(plotKey);
                town.plotsKeys.add(plotKey);
                town.register();

                chief.townsNames.add(args[0]);
                chief.register();

                plot.register();
            }

        }else{
            new Error("town.alreadyExists", p);

        }

    }

}
