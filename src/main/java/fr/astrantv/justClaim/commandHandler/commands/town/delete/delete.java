package fr.astrantv.justClaim.commandHandler.commands.town.delete;

import fr.astrantv.justClaim.Error;
import fr.astrantv.justClaim.commandHandler.Arg;
import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.db.*;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class delete extends SubCommand {

    public delete(CommandSender sender) {
        super(sender);
        name = "delete";
        desc = "A command to delete a town";

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

        if(m.IsRegistered()){
            m = m.GetMemberFromDb();

            String townName = m.getTownsNames().get(0);
            if(args.length == 1){
                townName = args[0];
            }

            Town town = new Town(townName);
            MemberInTown mInTown = town.GetMemberInTown(m);

            if(mInTown.GetMaxPower(town) == 64){
                town.unRegister();
                m.removeTownName(townName);
                m.register();
            }

        }

    }

}
