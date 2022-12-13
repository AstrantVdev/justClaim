package fr.astrantv.justClaim.commandHandler.commands.town.role;

import fr.astrantv.justClaim.commandHandler.SubCommand;
import fr.astrantv.justClaim.commandHandler.commands.town.member.role.add.add;
import fr.astrantv.justClaim.commandHandler.commands.town.role.addOne.addOne;
import fr.astrantv.justClaim.commandHandler.commands.town.role.remove.remove;
import fr.astrantv.justClaim.commandHandler.commands.town.role.removeOne.removeOne;
import fr.astrantv.justClaim.commandHandler.commands.town.role.set.set;
import org.bukkit.command.CommandSender;

public class role extends SubCommand {
    public role(CommandSender sender) {
        super(sender);
        name = "role";
        desc = "A command to manage Roles of a Town";

        addSub(new addOne(sender));
        addSub(new removeOne(sender));
        addSub(new set(sender));
        addSub(new add(sender));
        addSub(new remove(sender));

    }

    @Override
    public void exe(String[] args) {

    }
}
