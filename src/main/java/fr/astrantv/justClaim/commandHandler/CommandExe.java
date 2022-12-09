package fr.astrantv.justClaim.commandHandler;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class CommandExe {
    SubCommand command;
    CommandSender sender;
    public CommandExe(CommandSender sender, SubCommand command, String[] args, int iteration){
        this.command = command;
        this.sender = sender;

        if(command.perm != null){

            if(!sender.hasPermission(command.perm)){
                return;

            }

        }

        if(!(sender instanceof Player)){

            if(command.playerOnly ){
                return;

            }

        }

        for(SubCommand sub : command.subCommands){

            if(sub.name.equalsIgnoreCase(args[iteration])){
                iteration ++;
                new CommandExe(sender, sub, args, iteration);
                return;

            }

        }

        int n = 0;
        for(Arg arg : command.args){
            boolean valid = true;
            String sendArg = null;

            try{
                sendArg = args[iteration + n];

            }catch(Exception e){

                if(arg.required){
                    valid = false;

                }

            }

            if(arg.choices.size() > 0){

                boolean isChoice = false;
                for(Object choice : arg.choices){

                    if(choice.toString().equalsIgnoreCase(sendArg)){
                        isChoice = true;

                    }

                }

                if(!isChoice){
                    valid = false;

                }

            }

            switch (arg.type){
                case INT:

                    try {
                        int argInt = Integer.parseInt(sendArg);

                        if(arg.minValue != null){

                            if(argInt < arg.minChr){
                                valid = false;

                            }

                        }

                        if(arg.minValue != null){

                            if(argInt > arg.minChr){
                                valid = false;

                            }

                        }

                    } catch (NumberFormatException nfe) {
                        valid = false;

                    }
                    break;

                case STRING:

                    if(arg.minChr != null){

                        if(sendArg.length() < arg.minChr){
                            valid = false;

                        }

                    }

                    if(arg.maxChr != null){

                        if(sendArg.length() > arg.maxChr){
                            valid = false;

                        }

                    }
                    break;

                case BOOLEAN:
                    try {
                        boolean argBool = Boolean.parseBoolean(sendArg);

                    } catch (NumberFormatException nfe) {
                        valid = false;

                    }
                    break;

            }

            if(!valid){return;}

        }

        command.exe(Arrays.copyOfRange(args, iteration, args.length));

    }

}
