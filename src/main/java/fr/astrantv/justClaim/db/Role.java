package fr.astrantv.justClaim.db;

import com.mongodb.client.MongoCollection;

import java.time.Duration;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static fr.astrantv.justClaim.Main.mongoD;

public class Role {
    private String name;
    private int power;
    private ArrayList<Perm> permissions = new ArrayList<>();

    public Role(String name, int power){
        this.name = name.toUpperCase();
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public ArrayList<Perm> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<Perm> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(Perm perm){
        permissions.add(perm);
    }

    public void removePermission(Perm perm){
        permissions.remove(perm);
    }

    public boolean HasPerm(Perm.PERM perm){
        for(Perm p : permissions){
            if(p.getPerm() == perm){
                return true;
            }
        }
        return false;
    }

    public Town GetTownFromDb(){
        MongoCollection<Town> towns = mongoD.getCollection("towns", Town.class);
        return towns.find(eq("name",name)).first();

    }

}
