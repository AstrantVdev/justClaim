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
    public int X;
    public int Z;
    public UUID worldUUID;
    public String townName;
    public ArrayList<SubPlot> subPlots = new ArrayList<>();
    public ArrayList<Rule> rules = new ArrayList<>();
    private MongoCollection<Plot> plots;

    public Plot() {
    }

    public Plot(Location loc) {
        X = loc.getChunk().getX();
        Z = loc.getChunk().getZ();
        worldUUID = loc.getWorld().getUID();

        plots = mongoD.getCollection("plots", Plot.class);

    }

    public Plot(UUID worldUuid, int X, int Z) {
        this.worldUUID = worldUuid;
        this.X = X;
        this.Z = Z;

        plots = mongoD.getCollection("plots", Plot.class);

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


    public boolean isRegistered(){
        return plots.find(and(
                eq("X",X),
                eq("Z",Z),
                eq("world",worldUUID))).first() != null;

    }

    public void register(){
        plots.deleteOne(and(
                eq("X",X),
                eq("Z",Z),
                eq("world",worldUUID)));
        plots.insertOne(this);
    }


    public Town getTown() {
        return new Town(townName);
    }

    public ArrayList<PlotKey> broooooookTownIntegrityCheck(PlotKey plot, ArrayList<PlotKey> checkingPlots){
        Town t = new Town(townName);

        for(PlotKey p : plot.getNears(t)){

            if(checkingPlots.contains(p)){
                checkingPlots.remove(p);
                broooooookTownIntegrityCheck(p, checkingPlots);

            }

        }

        return checkingPlots;

    }

    //would make a portion of the town unattached to it.
    public boolean BronhnIntegrity(){
        Town t = new Town(townName);
        ArrayList<PlotKey> checkingPlots = t.getPlotsKeys();
        PlotKey center = t.getCenter();

        checkingPlots = broooooookTownIntegrityCheck(center, checkingPlots);

        return checkingPlots.size() != 0;

    }

    public boolean playerHasPermToBlockInteract(Player p, Location loc){

        if(getSubPlots() != null){

        }

        return false;
    }

}
