package fr.astrantv.justClaim.db;

import java.util.ArrayList;

public class Rule {
    private String name;
    private int superior;
    private int inferior;
    private ArrayList<ArrayList<Integer>> yesBetween = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> noBetween = new ArrayList<>();
    private int yes;
    private int no;
    private Boolean pvp;
    private BlockPerm build;
    private BlockPerm destroy;
    private BlockPerm blockInteract;
    private BlockPerm flow;
    private BlockPerm grow;
    private BlockPerm blockFormation;
    private BlockPerm explosion;
    private BlockPerm fade;
    private EntityPerm entityInteract;
    private EntityPerm entityAttack;

    public Rule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSuperior() {
        return superior;
    }

    public void setSuperior(int superior) {
        this.superior = superior;
    }

    public int getInferior() {
        return inferior;
    }

    public void setInferior(int inferior) {
        this.inferior = inferior;
    }

    public ArrayList<ArrayList<Integer>> getYesBetween() {
        return yesBetween;
    }

    public void setYesBetween(ArrayList<ArrayList<Integer>> yesBetween) {
        this.yesBetween = yesBetween;
    }

    public ArrayList<ArrayList<Integer>> getNoBetween() {
        return noBetween;
    }

    public void setNoBetween(ArrayList<ArrayList<Integer>> noBetween) {
        this.noBetween = noBetween;
    }

    public int getYes() {
        return yes;
    }

    public void setYes(int yes) {
        this.yes = yes;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boolean getPvp() {
        return pvp;
    }

    public void setPvp(Boolean pvp) {
        this.pvp = pvp;
    }

    public BlockPerm getBuild() {
        return build;
    }

    public void setBuild(BlockPerm build) {
        this.build = build;
    }

    public BlockPerm getDestroy() {
        return destroy;
    }

    public void setDestroy(BlockPerm destroy) {
        this.destroy = destroy;
    }

    public BlockPerm getBlockInteract() {
        return blockInteract;
    }

    public void setBlockInteract(BlockPerm blockInteract) {
        this.blockInteract = blockInteract;
    }

    public BlockPerm getFlow() {
        return flow;
    }

    public void setFlow(BlockPerm flow) {
        this.flow = flow;
    }

    public BlockPerm getGrow() {
        return grow;
    }

    public void setGrow(BlockPerm grow) {
        this.grow = grow;
    }

    public BlockPerm getBlockFormation() {
        return blockFormation;
    }

    public void setBlockFormation(BlockPerm blockFormation) {
        this.blockFormation = blockFormation;
    }

    public BlockPerm getExplosion() {
        return explosion;
    }

    public void setExplosion(BlockPerm explosion) {
        this.explosion = explosion;
    }

    public BlockPerm getFade() {
        return fade;
    }

    public void setFade(BlockPerm fade) {
        this.fade = fade;
    }

    public EntityPerm getEntityInteract() {
        return entityInteract;
    }

    public void setEntityInteract(EntityPerm entityInteract) {
        this.entityInteract = entityInteract;
    }

    public EntityPerm getEntityAttack() {
        return entityAttack;
    }

    public void setEntityAttack(EntityPerm entityAttack) {
        this.entityAttack = entityAttack;
    }
}
