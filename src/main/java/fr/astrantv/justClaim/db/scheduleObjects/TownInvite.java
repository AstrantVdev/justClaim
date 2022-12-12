package fr.astrantv.justClaim.db.scheduleObjects;

import com.mongodb.client.MongoCollection;
import fr.astrantv.justClaim.db.Town;
import org.bson.codecs.pojo.annotations.BsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static fr.astrantv.justClaim.Main.mongoD;

public class TownInvite {
    private Date expirationDate;
    private String townName;
    private UUID invitedUUID;

    public TownInvite(){

    }

    public TownInvite(Date expirationDate, String townName, UUID invitedUUID) {
        this.expirationDate = expirationDate;
        this.townName = townName;
        this.invitedUUID = invitedUUID;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public UUID getInvitedUUID() {
        return invitedUUID;
    }

    public void setInvitedUUID(UUID invitedUUID) {
        this.invitedUUID = invitedUUID;
    }

    public boolean IsRegistered(){
        MongoCollection<TownInvite> townInvites = mongoD.getCollection("townInvites", TownInvite.class);
        return townInvites.find((and(
                eq("townName",townName),
                eq("invitedUUID",invitedUUID)))).first() != null;

    }

    public void register(){
        MongoCollection<TownInvite> townInvites = mongoD.getCollection("townInvites", TownInvite.class);
        townInvites.insertOne(this);

    }

    public void unRegister(){
        MongoCollection<TownInvite> townInvites = mongoD.getCollection("townInvites", TownInvite.class);
        townInvites.deleteOne(and(
                eq("townName",townName),
                eq("invitedUUID",invitedUUID)));

    }
}
