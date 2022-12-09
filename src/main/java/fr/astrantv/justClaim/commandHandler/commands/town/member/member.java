package fr.astrantv.justClaim.commandHandler.commands.town.member;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.member.add.add;
import fr.astrantv.justClaim.commandHandler.commands.town.member.remove.remove;
import fr.astrantv.justClaim.commandHandler.commands.town.member.role.role;
import org.bukkit.command.CommandSender;

public class member extends SubCommand {

        public member(CommandSender sender){
            super(sender);
            name = "member";
            desc = "A command to manage the Members of a Town";

            subCommands.add(new add(sender));
            subCommands.add(new remove(sender));
            subCommands.add(new role(sender));
        }

        @Override
        public void exe(String[] args) {

        }

}
