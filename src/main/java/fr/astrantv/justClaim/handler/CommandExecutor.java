package fr.astrantv.justClaim.handler;

import fr.astrantv.justClaim.handler.commands.color.color;
import fr.astrantv.justClaim.handler.commands.town.town;
import fr.astrantv.justClaim.handler.commands.attract.attract;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length != 0){

            SubCommand subCom = null;
            for(SubCommand sub : commandsList(sender)){

                if(sub.name.equalsIgnoreCase(args[0])){
                    subCom = sub;
                    break;

                }

            }

            if(subCom != null){
                new CommandExe(sender, subCom, args, 1);

            }

        }

        return false;
    }

    public static ArrayList<SubCommand> commandsList(CommandSender sender){
        ArrayList<SubCommand> list = new ArrayList<>();
        list.add(new color(sender));
        list.add(new town(sender));
        list.add(new attract(sender));

        return list;

    }

}
