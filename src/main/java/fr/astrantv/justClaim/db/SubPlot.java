package fr.astrantv.justClaim.db;

import org.bukkit.Location;

import java.util.ArrayList;

public class SubPlot {
    private String name;
    private TYPE type;

    private ArrayList<Plot> yesSubPlots = new ArrayList<>();
    private ArrayList<Plot> noSubPlots = new ArrayList<>();
    private ArrayList<Location> yesBlocks = new ArrayList<>();
    private ArrayList<Location> noBlocks = new ArrayList<>();
    private ArrayList<String> rulesNames = new ArrayList<>();

    public SubPlot(String name, TYPE type) {
        this.name = name;
        this.type = type;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public ArrayList<Plot> getYesSubPlots() {
        return yesSubPlots;
    }

    public void setYesSubPlots(ArrayList<Plot> yesSubPlots) {
        this.yesSubPlots = yesSubPlots;
    }

    public ArrayList<Plot> getNoSubPlots() {
        return noSubPlots;
    }

    public void setNoSubPlots(ArrayList<Plot> noSubPlots) {
        this.noSubPlots = noSubPlots;
    }

    public ArrayList<Location> getYesBlocks() {
        return yesBlocks;
    }

    public void setYesBlocks(ArrayList<Location> yesBlocks) {
        this.yesBlocks = yesBlocks;
    }

    public ArrayList<Location> getNoBlocks() {
        return noBlocks;
    }

    public void setNoBlocks(ArrayList<Location> noBlocks) {
        this.noBlocks = noBlocks;
    }

    public ArrayList<String> getRulesNames() {
        return rulesNames;
    }

    public void setRulesNames(ArrayList<String> rulesNames) {
        this.rulesNames = rulesNames;
    }

    public enum TYPE{
        CUBOID,

    }
}
