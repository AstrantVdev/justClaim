package fr.astrantv.justClaim.db;

import java.util.ArrayList;

public class Role {
    private String name;
    private int power;
    private ArrayList<PERM> permissions = new ArrayList<>();

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

    public ArrayList<PERM> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<PERM> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(PERM perm){
        permissions.add(perm);
    }

    public void removePermission(PERM perm){
        permissions.remove(perm);
    }

    public boolean hasPerm(PERM perm){
        return permissions.contains(perm);
    }

    public enum PERM{
        PLOT_ADD,
        PLOT_REMOVE,
        MONEY_ADD,
        MONEY_REMOVE,
        MEMBER_ADD,
        MEMBER_REMOVE,
        ROLE_ADD,
        ROLE_REMOVE,
        RULE_ADD,
        RULE_REMOVE,
        SUBPLOT_ADD,
        SUBPLOT_REMOVE

    }

}
