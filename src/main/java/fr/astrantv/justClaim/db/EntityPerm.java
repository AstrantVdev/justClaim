package fr.astrantv.justClaim.db;

import org.bukkit.entity.EntityType;

import java.util.ArrayList;

public class EntityPerm {
    private EntityType type;
    private ArrayList<EntityType> types = new ArrayList<>();

    public EntityPerm(EntityType type, ArrayList<EntityType> types) {
        this.type = type;
        this.types = types;
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    public ArrayList<EntityType> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<EntityType> types) {
        this.types = types;
    }
}
