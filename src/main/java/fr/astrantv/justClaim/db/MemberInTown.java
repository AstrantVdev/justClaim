package fr.astrantv.justClaim.db;

import java.util.ArrayList;
import java.util.UUID;

public class MemberInTown {
    private UUID uuid;
    private ArrayList<String> rolesNames;

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

    public ArrayList<String> getRolesNames() {
        return rolesNames;
    }

    public void setRolesNames(ArrayList<String> rolesNames) {
        this.rolesNames = rolesNames;
    }

    public void addRoleName(String role){
        rolesNames.add(role);
    }

    public void removeRoleName(String role){
        rolesNames.remove(role);
    }

    public ArrayList<Role> GetRoles(Town town){
        ArrayList<Role> roles = new ArrayList<>();

        for(Role role : town.getRoles()){

            if(rolesNames.contains(role.getName())){
                roles.add(role);
            }

        }

        return roles;
    }

    public int GetMaxPower(Town town){
        int max = 0;

        for(Role role : town.getRoles()){

            if(role.getPower() > max){
                max = role.getPower();
            }

        }

        return max;
    }

    public boolean hasPerm(Perm.PERM perm, Town town){

        for (Role role : GetRoles(town)) {

            if(role.HasPerm(perm)){
                return true;
            }

        }

        return false;

    }

}
