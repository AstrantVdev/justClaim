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

                if(arg.isRequired()){
                    valid = false;

                }

            }

            if(arg.getChoices().size() > 0){

                boolean isChoice = false;
                for(Object choice : arg.getChoices()){

                    if(choice.toString().equalsIgnoreCase(sendArg)){
                        isChoice = true;

                    }

                }

                if(!isChoice){
                    valid = false;

                }

            }

            switch (arg.getType()){
                case INT:

                    try {
                        int argInt = Integer.parseInt(sendArg);

                        if(arg.getMinValue() != null){

                            if(argInt < arg.getMinChr()){
                                valid = false;

                            }

                        }

                        if(arg.minValue != null){

                            if(argInt > arg.getMinChr()){
                                valid = false;

                            }

                        }

                    } catch (NumberFormatException nfe) {
                        valid = false;

                    }
                    break;

                case STRING:

                    if(arg.getMinChr() != null){

                        if(sendArg.length() < arg.getMinChr()){
                            valid = false;

                        }

                    }

                    if(arg.getMaxChr() != null){

                        if(sendArg.length() > arg.getMaxChr()){
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
