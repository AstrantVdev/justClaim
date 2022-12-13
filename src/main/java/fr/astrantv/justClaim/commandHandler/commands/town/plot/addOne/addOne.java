package fr.astrantv.justClaim.commandHandler.commands.town.plot.addOne;
import fr.astrantv.justClaim.messageHandler.Error;
import fr.astrantv.justClaim.db.*;
import fr.astrantv.justClaim.commandHandler.Arg;
import fr.astrantv.justClaim.commandHandler.SubCommand;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addOne extends SubCommand {

    public addOne(CommandSender sender) {
        super(sender);
        name = "addOne";
        desc = "A command to add a plot";

        Player p = (Player) sender;
        Member m = new Member(p.getUniqueId());

        if(m.getTownsNames() != null){

            addArg(new Arg("town")
                .setMinChr(2)
                .setMaxChr(32)
                .setRequired(false)
                .addChoice(m.GetTowns())
            );

        }

    }

    @Override
    public void exe(String[] args) {
        Player p = (Player) sender;
        Member m = new Member(p.getUniqueId());

        if(m.IsRegistered()){
            m = m.GetMemberFromDb();
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
                    MemberInTown mInTown = town.GetMemberInTown(m);

                    if(mInTown.hasPerm(Perm.PERM.PLOT_ADD, town)) {
                        town.addPlotKey(plotKey);
                        town.register();

                        plot.register();

                    }

                }

            }else{
                new Error("m.er.human.hasNoTown", p);

            }

        }else{
            new Error("m.er.human.hasNoTown", p);

        }

    }

}
