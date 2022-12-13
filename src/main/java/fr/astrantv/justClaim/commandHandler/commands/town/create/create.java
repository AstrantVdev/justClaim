package fr.astrantv.justClaim.commandHandler.commands.town.create;

import fr.astrantv.justClaim.messageHandler.Error;
import fr.astrantv.justClaim.db.*;
import fr.astrantv.justClaim.commandHandler.Arg;
import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class create extends SubCommand {

    public create(CommandSender sender) {
        super(sender);
        name = "create";
        desc = "A command to create a town";
        playerOnly = true;

        addArg(new Arg("town")
                .setMinChr(2)
                .setMaxChr(20));

    }

    @Override
    public void exe(String[] args) {
        Town town = new Town(args[0]);
        Player p = (Player) sender;

        if(!town.IsRegistered()){
            UUID uuid = p.getUniqueId();
            Member member = new Member(uuid);
            Plot plot = new Plot(p.getLocation());
            PlotKey plotKey = new PlotKey(p.getLocation());

            if(!plot.IsRegistered()){
                MemberInTown mInTown = new MemberInTown();
                town.addRole(town.leaderRole());
                mInTown.addRoleName(town.leaderRole().getName());
                town.addMemberInTown(mInTown);
                plotKey.setAlphaPlotName("alpha");
                town.addAlphaPlot(plotKey);
                town.addPlotKey(plotKey);
                town.register();

                member.addTownName(town.getName());
                member.register();

                plot.register();
            }

        }else{
            new Error("town.alreadyExists", p);

        }

    }

}
