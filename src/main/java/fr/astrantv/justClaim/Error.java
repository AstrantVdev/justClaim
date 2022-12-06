package fr.astrantv.justClaim;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Error {
    String path;

    public Error(String path, Player p){
        this.path = path;
        String mes = Main.configs("FR_fr").getString("m.er."+path);

        p.sendMessage(ChatColor.RED + "No! " + mes);
    }

}
