package fr.astrantv.justClaim.utils;

import org.bukkit.DyeColor;

public class enums {

    public enum COLORS{
        BLACK(DyeColor.BLACK),
        BLUE(DyeColor.BLUE),
        BROWN(DyeColor.BROWN),
        CYAN(DyeColor.CYAN),
        GRAY(DyeColor.GRAY),
        GREEN(DyeColor.GREEN),
        LIGHT_BLUE(DyeColor.LIGHT_BLUE),
        LIGHT_GRAY(DyeColor.LIGHT_GRAY),
        LIME(DyeColor.LIME),
        MAGENTA(DyeColor.MAGENTA),
        ORANGE(DyeColor.ORANGE),
        PINK(DyeColor.PINK),
        PURPLE(DyeColor.PURPLE),
        RED(DyeColor.RED),
        WHITE(DyeColor.WHITE),
        YELLOW(DyeColor.YELLOW);

        public final DyeColor color;

        COLORS(DyeColor color){
            this.color = color;
        }

    }

}
