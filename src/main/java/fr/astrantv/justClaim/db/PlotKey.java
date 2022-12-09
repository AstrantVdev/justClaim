package fr.astrantv.justClaim.db;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.UUID;

import static fr.astrantv.justClaim.Main.plugin;

public class PlotKey {
    private int X;
    private int Z;
    private UUID worldUUID;
    private String alphaPlotName;

    private PlotKey alphaPlot;


    public PlotKey(){

    }

    public PlotKey(Location loc){
        X = loc.getChunk().getX();
        Z = loc.getChunk().getZ();
        worldUUID = loc.getWorld().getUID();
    }

    public PlotKey(int X, int Z, UUID worldUUID){
        this.X = X;
        this.Z = Z;
        this.worldUUID = worldUUID;
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

    public String getAlphaPlotName() {
        return alphaPlotName;
    }

    public void setAlphaPlotName(String alphaPlotName) {
        this.alphaPlotName = alphaPlotName;
    }

    public ArrayList<PlotKey> getNears(Town t){
        ArrayList<PlotKey> nears = new ArrayList<>();
        World w = plugin.getServer().getWorld(worldUUID);

        for(int x = X-1;x<X+2; x+=2){

            for(int z = Z-1;z<Z+2; z+=2){
                PlotKey near = new PlotKey(new Location(w, X, 2, Z));

                if(t.getPlotsKeys().contains(near)){
                    nears.add(near);
                }

            }

        }

        return nears;

    }

}
