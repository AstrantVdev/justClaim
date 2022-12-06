package fr.astrantv.justClaim.handler;
import java.util.ArrayList;

import org.bukkit.command.CommandSender;
public abstract class SubCommand {
    public CommandSender sender;
    public String perm;
    public String name = "";
    public String desc = "";
    public Boolean playerOnly = true;
    public ArrayList<Arg> args = new ArrayList<>();
    public ArrayList<SubCommand> subCommands = new ArrayList<>();

    public SubCommand(CommandSender sender) {
        this.sender = sender;
    }

    public abstract void exe(String[] args);

}