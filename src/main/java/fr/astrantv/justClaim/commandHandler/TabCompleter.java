package fr.astrantv.justClaim.commandHandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    public int length = 0;
    public int lastSubIndex = 0;
    @Override
    public List<String> onTabComplete (CommandSender sender, Command cmd, String label, String[] args){
        List<String> complete = new ArrayList<>();
        List<String> choices = new ArrayList<>();
        List<String> commands = new ArrayList<>();
        Boolean fillInt = false;
        length = args.length;

        SubCommand command = null;
        for(SubCommand sub : CommandExecutor.commandsList(sender)){
            String name = sub.name;
            commands.add(name);

            if(name.equalsIgnoreCase(args[0])){
                command = sub;

            }

        }

        if(args.length != 1){

            if(command == null){
                return null;

            }else{
                command = getLastSub(command, args, 1, length);

            }

            if(length == lastSubIndex+1){
                for (SubCommand sub : command.subCommands){
                    choices.add(sub.name);

                }
            }

            int maxArgsIndex = lastSubIndex+command.args.size();
            if(length <= maxArgsIndex){
                Arg arg = command.args.get(maxArgsIndex-length);

                ArrayList<String> argChoices = arg.choices;

                Boolean nullChoices = false;
                if(choices != null){

                    for(Object choice:argChoices){
                        choices.add(choice.toString());
                    }

                }else {

                    switch (arg.type) {

                        case INT:
                            try {
                                int i = Integer.parseInt(args[length - 1]);

                                Boolean valid = true;
                                if (arg.maxValue != null) {
                                    if (i > arg.maxValue) {
                                        valid = false;
                                    }
                                }
                                if (arg.minValue != null) {
                                    if (i < arg.maxValue) {
                                        valid = false;
                                    }
                                }

                                if (valid) {
                                    fillInt = true;
                                }

                            } catch (Exception ex) {}
                            break;

                        case BOOLEAN:
                            choices.add("false");
                            choices.add("true");
                            break;

                    }

                }

            }


        }else{
            choices = commands;
        }


        for (String choice : choices){

            if(choice.toUpperCase().startsWith(args[length-1].toUpperCase())){
                complete.add(choice);

            }

        }


        if(fillInt){

            for (int i = 0; i < 10; i++){

                choices.add(String.valueOf(i));

            }

        }


        return complete;

    }

    public SubCommand getLastSub(SubCommand baseSub, String[] args, int i, int max){
        SubCommand lastSub = baseSub;
        lastSubIndex = i;

        for(SubCommand sub : baseSub.subCommands) {

            if (sub.name.equalsIgnoreCase(args[i])) {

                if(i<max+1){
                    lastSub = getLastSub(sub, args, i+1, max);
                    break;

                }

            }

        }

        return lastSub;

    }

}
