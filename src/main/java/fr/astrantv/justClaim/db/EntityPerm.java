package fr.astrantv.justClaim.db;

import org.bukkit.entity.EntityType;

import java.util.ArrayList;

public class EntityPerm {
    private boolean byDefault;
    private EntityType passiveType;
    private ArrayList<EntityType> activeTypes = new ArrayList<>();

    public EntityPerm() {

    }

    public boolean getByDefault() {
        return byDefault;
    }

    public void setByDefault(boolean byDefault) {
        this.byDefault = byDefault;
    }

    public EntityType getPassiveType() {
        return passiveType;
    }

    public void setPassiveType(EntityType passiveType) {
        this.passiveType = passiveType;
    }

    public ArrayList<EntityType> getActiveTypes() {
        return activeTypes;
    }

    public void setActiveTypes(ArrayList<EntityType> activeTypes) {
        this.activeTypes = activeTypes;
    }
}
