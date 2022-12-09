package fr.astrantv.justClaim.db;

import java.util.ArrayList;
import java.util.UUID;

public class MemberInTown {
    private UUID uuid;
    private ArrayList<Role> roles;

    public MemberInTown(){

    }

    public MemberInTown(UUID uuid){
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        roles.add(role);
    }

    public void removeRole(Role role){
        roles.remove(role);
    }

    public boolean hasPerm(Role.PERM perm){

        for (Role role : roles) {

            if(role.hasPerm(perm)){
                return true;
            }

        }

        return false;

    }

}
