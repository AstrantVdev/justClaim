package fr.astrantv.justClaim.db;

public class Perm {
    PERM perm;
    int limit;
    int limitDuration; //in minutes

    public Perm(){
    }

    public Perm(PERM perm, int limit, int limitDuration){
        this.perm = perm;
        this.limit = limit;
        this.limitDuration = limitDuration;
    }

    public PERM getPerm() {
        return perm;
    }

    public void setPerm(PERM perm) {
        this.perm = perm;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimitDuration() {
        return limitDuration;
    }

    public void setLimitDuration(int limitDuration) {
        this.limitDuration = limitDuration;
    }

    public enum PERM{
        PLOT_ADD,
        PLOT_REMOVE,
        MONEY_ADD,
        MONEY_REMOVE,
        MEMBER_ADD,
        MEMBER_REMOVE,
        MEMBER_ROLE_ADD,
        MEMBER_ROLE_REMOVE,
        ROLE_ADD,
        ROLE_REMOVE,
        RULE_ADD,
        RULE_REMOVE,
        SUBPLOT_ADD,
        SUBPLOT_REMOVE,
        SUBPLOT_RULE_ADD,
        SUBPLOT_RULE_REMOVE,

    }

}
