package fr.astrantv.justClaim.handler.commands.town.plot.add;
import fr.astrantv.justClaim.Error;
import fr.astrantv.justClaim.db.Member;
import fr.astrantv.justClaim.db.Plot;
import fr.astrantv.justClaim.db.PlotKey;
import fr.astrantv.justClaim.db.Town;
import fr.astrantv.justClaim.handler.Arg;
import fr.astrantv.justClaim.handler.SubCommand;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class add extends SubCommand {

    public add(CommandSender sender) {
        super(sender);
        name = "add";
        desc = "A command to add a plot";

        Player p = (Player) sender;
        Member m = new Member(p.getUniqueId());

        if(m.getTownsNames() != null){
            Arg town = new Arg();
            town.minChr = 2;
            town.maxChr = 32;
            town.required = false;
            town.choices = m.GetTowns();
            args.add(town);

        }

    }

    @Override
    public void exe(String[] args) {
        Player p = (Player) sender;
        Member m = new Member(p.getUniqueId());

        if(m.getTownsNames() != null){
            Location loc = p.getLocation();
            Plot plot = new Plot(loc);

            if(!plot.IsRegistered()){
                PlotKey plotKey = new PlotKey(loc);

                String townName = m.getTownsNames().get(0);
                if(args.length == 1){
                    townName = args[0];
                }

                Town town = new Town(townName);
                town = town.GetTownFromDb();

                if(plotKey.getNears(town) != null){
                    town.addPlotKey(plotKey);
                    town.register();

                    plot.register();

                }

            }else{
                new Error("m.er.human.hasNoTown", p);

            }

        }else{
            new Error("m.er.human.hasNoTown", p);

        }

    }

}
