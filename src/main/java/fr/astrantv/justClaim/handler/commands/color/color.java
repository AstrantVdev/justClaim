package fr.astrantv.justClaim.handler.commands.color;
import java.util.ArrayList;
import java.util.EnumSet;

import fr.astrantv.justClaim.handler.Arg;
import fr.astrantv.justClaim.handler.commands.color.sheep.sheep;
import fr.astrantv.justClaim.handler.SubCommand;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static com.mongodb.client.model.Filters.eq;

public class color extends SubCommand {
    public color(CommandSender sender){
        super(sender);
        name = "color";
        desc = "Foxy ! Give colored wool uwu";

        Arg colorArg = new Arg();
        colorArg.required = true;
        colorArg.choices = new ArrayList<>(EnumSet.allOf(COLORS.class));
        args.add(colorArg);

        subCommands.add(new sheep(sender));

    }

    @Override
    public void exe(String[] args) {
        Player player = (Player) sender;

        ItemStack wool = new ItemStack(Material.BLACK_WOOL);
        for(COLORS color : COLORS.values()){
            String colorStr = color.toString();

            if(args[0].equalsIgnoreCase(colorStr)){
                wool = new ItemStack(color.getMaterial());

                break;

            }

        }

        player.getInventory().addItem(wool);

    }
    public enum COLORS{
        BLACK("BLACK_WOOL"),
        BLUE("BLUE_WOOL"),
        BROWN("BROWN_WOOL"),
        CYAN("CYAN_WOOL"),
        GRAY("GRAY_WOOL"),
        GREEN("GREEN_WOOL"),
        LIGHT_BLUE("LIGHT_BLUE_WOOL"),
        LIGHT_GRAY("LIGHT_GRAY_WOOL"),
        LIME("LIME_WOOL"),
        MAGENTA("MAGENTA_WOOL"),
        ORANGE("ORANGE_WOOL"),
        PINK("PINK_WOOL"),
        PURPLE("PURPLE_WOOL"),
        RED("RED_WOOL"),
        WHITE("WHITE_WOOL"),
        YELLOW("YELLOW_WOOL");

        private final String material;

        COLORS(String material){
            this.material = material;
        }

        public Material getMaterial() {
            return Material.getMaterial(this.material);
        }

    }

}
