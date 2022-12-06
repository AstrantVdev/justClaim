package fr.astrantv.justClaim.handler.commands.town.plot.claim;
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

public class claim extends SubCommand {

    public claim(CommandSender sender) {
        super(sender);
        name = "claim";
        desc = "A command to claim a plot";

        Player p = (Player) sender;
        Member m = new Member(p.getUniqueId());

        if(m.getTownsNames() != null){
            Arg town = new Arg();
            town.minChr = 2;
            town.maxChr = 32;
            town.required = false;
            town.choices = m.getTowns();
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

            if(!plot.isRegistered()){
                PlotKey plotKey = new PlotKey(loc);

                String townName = m.getTownsNames().get(0);
                if(args.length == 1){
                    townName = args[0];
                }
                Town town = new Town(townName);

                if(plotKey.getNears(town) != null){
                    town.plotsKeys.add(plotKey);
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
