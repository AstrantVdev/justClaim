package fr.astrantv.justClaim.commandHandler.commands.town.plot.remove;

import fr.astrantv.justClaim.Error;
import fr.astrantv.justClaim.db.*;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import fr.astrantv.justClaim.commandHandler.SubCommand;

public class remove extends SubCommand {

    public remove(CommandSender sender) {
        super(sender);
        name = "remove";
        desc = "A command to remove a plot";

        Player p = (Player) sender;
        Member m = new Member(p.getUniqueId());

    }

    @Override
    public void exe(String[] args) {
        Player p = (Player) sender;
        Member m = new Member(p.getUniqueId());

        Location loc = p.getLocation();
        Plot plot = new Plot(loc);

        if(!plot.IsRegistered()){
            PlotKey plotKey = new PlotKey(loc);
            plot = plot.GetPlotFromDb();

            if(m.IsRegistered()){
                m = m.GetMemberFromDb();
                Town t = new Town(plot.getTownName());
                t = t.GetTownFromDb();

                if(m.hasTown(t)) {
                    MemberInTown mInTown = t.GetMemberInTown(m);

                    if(mInTown.hasPerm(Role.PERM.PLOT_REMOVE)) {
                        t.removePlotKey(plotKey);
                        t.register();

                        plot.unRegister();

                        p.sendMessage("§aPlot removed");

                    }

                }

            }

        }else{
            new Error("m.er.human.hasNoTown", p);

        }

    }

}
