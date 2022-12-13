package fr.astrantv.justClaim.commandHandler.commands.town.member;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.member.addOne.addOne;
import fr.astrantv.justClaim.commandHandler.commands.town.member.removeOne.removeOne;
import fr.astrantv.justClaim.commandHandler.commands.town.member.role.role;
import org.bukkit.command.CommandSender;

public class member extends SubCommand {

        public member(CommandSender sender){
            super(sender);
            name = "member";
            desc = "A command to manage the Members of a Town";

            addSub(new addOne(sender));
            addSub(new removeOne(sender));
            addSub(new role(sender));
        }

        @Override
        public void exe(String[] args) {

        }

}
