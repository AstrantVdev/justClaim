package fr.astrantv.justClaim.db;

import org.bukkit.Material;

import java.util.ArrayList;

public class BlockPerm {
    private Boolean byDefault;
    private ArrayList<Material> yes = new ArrayList<>();
    private ArrayList<Material> no = new ArrayList<>();

    public Boolean getByDefault() {
        return byDefault;
    }

    public void setByDefault(Boolean byDefault) {
        this.byDefault = byDefault;
    }

    public ArrayList<Material> getYes() {
        return yes;
    }

    public void setYes(ArrayList<Material> yes) {
        this.yes = yes;
    }

    public ArrayList<Material> getNo() {
        return no;
    }

    public void setNo(ArrayList<Material> no) {
        this.no = no;
    }
}
