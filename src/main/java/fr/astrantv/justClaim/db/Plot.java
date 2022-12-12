package fr.astrantv.justClaim.db;

import com.mongodb.client.MongoCollection;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static fr.astrantv.justClaim.Main.mongoD;

public class Plot {
    private int X;
    private int Z;
    private UUID worldUUID;
    private String townName;
    private ArrayList<SubPlot> subPlots = new ArrayList<>();
    private ArrayList<Rule> rules = new ArrayList<>();

    public Plot() {
    }

    public Plot(Location loc) {
        X = loc.getChunk().getX();
        Z = loc.getChunk().getZ();
        worldUUID = loc.getWorld().getUID();

    }

    public Plot(UUID worldUuid, int X, int Z) {
        this.worldUUID = worldUuid;
        this.X = X;
        this.Z = Z;

    }

    public Plot(PlotKey plotKey) {
        this.worldUUID = plotKey.getWorldUUID();
        this.X = plotKey.getX();
        this.Z = plotKey.getZ();

    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getZ() {
        return Z;
    }

    public void setZ(int z) {
        Z = z;
    }

    public UUID getWorldUUID() {
        return worldUUID;
    }

    public void setWorldUUID(UUID worldUUID) {
        this.worldUUID = worldUUID;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public ArrayList<SubPlot> getSubPlots() {
        return subPlots;
    }

    public void setSubPlots(ArrayList<SubPlot> subPlots) {
        this.subPlots = subPlots;
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }

    public void setRules(ArrayList<Rule> rules) {
        this.rules = rules;
    }


    public boolean IsRegistered(){
        MongoCollection<Plot> plots = mongoD.getCollection("plots", Plot.class);
        return plots.find(and(
                eq("X",X),
                eq("Z",Z),
                eq("world",worldUUID))).first() != null;

    }

    public void unRegister(){
        MongoCollection<Plot> plots = mongoD.getCollection("plots", Plot.class);

        plots.deleteOne(and(
                eq("X",X),
                eq("Z",Z),
                eq("world",worldUUID)));
    }

    public void register(){
        unRegister();

        MongoCollection<Plot> plots = mongoD.getCollection("plots", Plot.class);
        plots.insertOne(this);
    }


    public Town GetTown() {
        return new Town(townName);
    }

    public PlotKey GetPlotKey() {
        return new PlotKey(X, Z, worldUUID);
    }

    public ArrayList<PlotKey> townIntegrityPlots(PlotKey plot, ArrayList<PlotKey> checkingPlots){
        Town t = new Town(townName);

        for(PlotKey p : plot.getNears(t)){

            if(checkingPlots.contains(p)){
                checkingPlots.remove(p);
                townIntegrityPlots(p, checkingPlots);

            }

        }

        return checkingPlots;

    }

    //would make a portion of the town unattached to it.
    public boolean IsBreakingTownIntegrity(){
        Town t = new Town(townName);

        ArrayList<PlotKey> checkingPlots = t.getPlotsKeys();
        String AlphaPlotName = checkingPlots.get(0).getAlphaPlotName();
        PlotKey alpha = t.GetAlphaPlot(AlphaPlotName);

        checkingPlots = townIntegrityPlots(alpha, checkingPlots);

        return checkingPlots.size() != 0;

    }

    public boolean IsAlpha(){
        Town t = GetTown();
        PlotKey p = GetPlotKey();
        return t.hasAlphaPlot(p);
    }

    public boolean playerHasPermToBlockInteract(Player p, Location loc){

        if(getSubPlots() != null){

        }

        return false;
    }

    public Plot GetPlotFromDb() {
        MongoCollection<Plot> plots = mongoD.getCollection("plots", Plot.class);
        return plots.find(and(
                eq("X",X),
                eq("Z",Z),
                eq("world",worldUUID))).first();
    }
}
