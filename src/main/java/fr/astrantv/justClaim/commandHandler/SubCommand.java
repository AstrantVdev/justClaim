package fr.astrantv.justClaim.commandHandler;
import java.util.ArrayList;

import org.bukkit.command.CommandSender;
public abstract class SubCommand {
    public CommandSender sender;
    public String perm;
    public String name;
    public String desc = "Just a lambda command";
    public Boolean playerOnly = true;
    public ArrayList<Arg> args = new ArrayList<>();
    public ArrayList<SubCommand> subCommands = new ArrayList<>();

    public SubCommand(CommandSender sender) {
        this.sender = sender;
    }

    public abstract void exe(String[] args);

    public void addSub(SubCommand subCommand) {
        addSub(subCommand);
    }

    public void addArg(Arg arg) {
        args.add(arg);
    }

}