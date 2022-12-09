package fr.astrantv.justClaim.db;

import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static fr.astrantv.justClaim.Main.mongoD;

public class Member {
    private UUID uuid;
    private ArrayList<String> townsNames = new ArrayList<>();

    public Member(){
    }

    public Member(UUID uuid){
        this.uuid = uuid;
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

    public void addTownName(String townName){
        townsNames.add(townName);
    }

    public void removeTownName(String townName){
        townsNames.remove(townName);
    }

    public boolean IsRegistered(){
        MongoCollection<Member> members = mongoD.getCollection("members", Member.class);
        return members.find(eq("uuid",uuid)).first() != null;

    }

    public void unRegister(){
        MongoCollection<Member> members = mongoD.getCollection("members", Member.class);
        members.deleteOne(eq("uuid",uuid));
    }

    public void register(){
        unRegister();

        MongoCollection<Member> members = mongoD.getCollection("members", Member.class);
        members.insertOne(this);
    }


    public ArrayList<Town> GetTowns(){
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

    public Member GetMemberFromDb(){
        MongoCollection<Member> members = mongoD.getCollection("members", Member.class);
        return members.find(eq("uuid",uuid)).first();
    }

}