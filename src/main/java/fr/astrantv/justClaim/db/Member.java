package fr.astrantv.justClaim.db;

import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static fr.astrantv.justClaim.Main.mongoD;

public class Member {
    private UUID uuid;
    public ArrayList<String> townsNames = new ArrayList<>();
    private MongoCollection<Member> members;

    public Member(){
    }
    public Member(UUID uuid){
        this.uuid = uuid;
        members = mongoD.getCollection("members", Member.class);

    }

    public UUID getUuid() {
        return uuid;

    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public ArrayList<String> getTownsNames() {
        return townsNames;
    }

    public void setTownsNames(ArrayList<String> townsNames) {
        this.townsNames = townsNames;
    }

    public boolean isRegistered(){
        return members.find(eq("uuid",uuid)).first() != null;

    }

    public void register(){
        members.deleteOne(eq("uuid",uuid));
        members.insertOne(this);
    }


    public ArrayList<Town> getTowns(){
        ArrayList<Town> towns = new ArrayList<>();
        for (String name : townsNames){
            Town t = new Town(name);
            towns.add(t);
        }

        return towns;

    }

    public boolean hasTown(Town town){
        String townName = town.getName();

        return townsNames.contains(townName);
    }


}