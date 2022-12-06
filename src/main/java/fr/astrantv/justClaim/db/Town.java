package fr.astrantv.justClaim.db;

import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static fr.astrantv.justClaim.Main.mongoD;

public class Town {
    private String name;
    private UUID chiefUUID;
    private PlotKey center;
    private Rule rule;
    private ArrayList<UUID> membersUUID = new ArrayList<>();
    private ArrayList<Rule> rules = new ArrayList<>();
    private ArrayList<Role> roles = new ArrayList<>();
    private ArrayList<SubPlot> subPlots = new ArrayList<>();
    private ArrayList<PlotKey> plotsKeys = new ArrayList<>();

    public Town() {

    }

    public Town(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getChiefUUID() {
        return chiefUUID;
    }

    public void setChiefUUID(UUID chiefUUID) {
        this.chiefUUID = chiefUUID;
    }

    public PlotKey getCenter() {
        return center;
    }

    public void setCenter(PlotKey center) {
        this.center = center;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public ArrayList<UUID> getMembersUUID() {
        return membersUUID;
    }

    public void setMembersUUID(ArrayList<UUID> members) {
        this.membersUUID = members;
    }

    public void addMemberUUID(UUID uuid){
        membersUUID.add(uuid);
    }

    public void removeMemberUUID(UUID uuid){
        membersUUID.remove(uuid);
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }

    public void setRules(ArrayList<Rule> rules) {
        this.rules = rules;
    }

    public void addRule(Rule rule){
        rules.add(rule);
    }

    public void remobveRule(Rule rule){
        rules.remove(rule);
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

    public ArrayList<SubPlot> getSubPlots() {
        return subPlots;
    }

    public void setSubPlots(ArrayList<SubPlot> subPlots) {
        this.subPlots = subPlots;
    }

    public void addSubPlot(SubPlot subPlot){
        subPlots.add(subPlot);
    }

    public void removeSubPlot(SubPlot subPlot){
        subPlots.remove(subPlot);
    }

    public ArrayList<PlotKey> getPlotsKeys() {
        return plotsKeys;
    }

    public void setPlotsKeys(ArrayList<PlotKey> plotsKeys) {
        this.plotsKeys = plotsKeys;
    }

    public void addPlotKey(PlotKey plotKey){
        plotsKeys.add(plotKey);
    }

    public void removePlotKey(PlotKey plotKey){
        plotsKeys.remove(plotKey);
    }

    public boolean IsRegistered(){
        MongoCollection<Town> towns = mongoD.getCollection("towns", Town.class);
        return towns.find(eq("name",name)).first() != null;

    }

    public void register(){
        MongoCollection<Town> towns = mongoD.getCollection("towns", Town.class);

        towns.deleteOne(eq("name",name));
        towns.insertOne(this);
    }

    public ArrayList<Plot> GetPlots(){
        ArrayList<Plot> plots = new ArrayList<>();
        for (PlotKey key : plotsKeys){
            Plot p = new Plot(key.worldUUID, key.X, key.Z);
            plots.add(p);
        }

        return plots;
    }

    public ArrayList<Member> GetMembers(){
        ArrayList<Member> members = new ArrayList<>();
        for (UUID uuid : membersUUID){
            Member m = new Member(uuid);
            members.add(m);
        }

        return members;
    }

    public enum NAMEERROR{
        TOOLONG,
        TOOSHORT,
        INAPPROPRIATE,
        FORBIDDENCHARACTER,
        NONE
    }

    public NAMEERROR nameError(){

        if(name.length() >=2){

            if(name.length() <= 32){
                return NAMEERROR.NONE;

            }else{
                return NAMEERROR.TOOLONG;

            }

        }else{
            return NAMEERROR.TOOSHORT;

        }

    }

}
