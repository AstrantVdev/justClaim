package fr.astrantv.justClaim.db;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonIgnore;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static fr.astrantv.justClaim.Main.mongoD;

public class Town {
    private String name;
    private Rule rule;
    private double money;
    private ArrayList<PlotKey> alphaPlots = new ArrayList<>();

    private ArrayList<MemberInTown> membersInTown = new ArrayList<>();
    private ArrayList<Rule> rules = new ArrayList<>();
    private ArrayList<Role> roles = new ArrayList<>();
    private ArrayList<SubPlot> subPlots = new ArrayList<>();
    private ArrayList<PlotKey> plotsKeys = new ArrayList<>();
    @BsonIgnore
    private MongoCollection<Town> towns = mongoD.getCollection("towns", Town.class);


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

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public ArrayList<PlotKey> getAlphaPlots() {
        return alphaPlots;
    }

    public void setAlphaPlots(ArrayList<PlotKey> alphaPlots) {
        this.alphaPlots = alphaPlots;
    }

    public void addAlphaPlot(PlotKey alphaPlot) {
        alphaPlots.add(alphaPlot);
    }

    public void removeAlphaPlot(PlotKey alphaPlot) {
        alphaPlots.remove(alphaPlot);
    }

    public boolean hasAlphaPlot(PlotKey alphaPlot) {
        return alphaPlots.contains(alphaPlot);
    }

    public ArrayList<MemberInTown> getMembersInTown() {
        return membersInTown;
    }

    public void setMembersInTown(ArrayList<MemberInTown> membersInTown) {
        this.membersInTown = membersInTown;
    }

    public void addMemberInTown(MemberInTown memberInTown){
        membersInTown.add(memberInTown);
    }

    public void removeMemberInTown(MemberInTown memberInTown){
        membersInTown.remove(memberInTown);
    }

    public boolean hasMemberInTown(MemberInTown memberInTown){
        return membersInTown.contains(memberInTown);
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

    public void removeRule(Rule rule){
        rules.remove(rule);
    }

    public boolean hasRule(Rule rule){
        return rules.contains(rule);
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

    public boolean hasRole(Role role){
        return roles.contains(role);
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

    public boolean hasSubPlot(SubPlot subPlot){
        return subPlots.contains(subPlot);
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

    public boolean hasPlotKey(PlotKey plotKey){
        return plotsKeys.contains(plotKey);
    }

    public boolean IsRegistered(){
        MongoCollection<Town> towns = mongoD.getCollection("towns", Town.class);
        return towns.find(eq("name",name)).first() != null;

    }

    public void register(){
        unRegister();

        MongoCollection<Town> towns = mongoD.getCollection("towns", Town.class);
        towns.insertOne(this);

    }

    public void unRegister(){
        MongoCollection<Town> towns = mongoD.getCollection("towns", Town.class);
        towns.deleteOne(eq("name",name));
    }
    public ArrayList<Plot> GetPlots(){
        ArrayList<Plot> plots = new ArrayList<>();

        for(PlotKey key : getPlotsKeys()){
            plots.add(new Plot(key));

        }

        return plots;
    }

    public ArrayList<Member> GetMembers(){
        ArrayList<Member> members = new ArrayList<>();
        for (MemberInTown member : membersInTown){
            Member m = new Member(member.getUuid());
            m = m.GetMemberFromDb();
            members.add(m);
        }

        return members;
    }

    public MemberInTown GetMemberInTown(Member member){
        for(Member m : GetMembers()){
            if(m.getUuid().equals(member.getUuid())){
                return membersInTown.get(GetMembers().indexOf(m));
            }
        }
        return null;
    }

    public Role GetRole(String name){
        for(Role role : roles){
            if(role.getName().equals(name)){
                return role;
            }
        }
        return null;
    }

    public Rule GetRule(String name){
        for(Rule rule : rules){
            if(rule.getName().equals(name)){
                return rule;
            }
        }
        return null;
    }

    public PlotKey GetAlphaPlot(String name){
        for(PlotKey plot : alphaPlots){
            if(plot.getAlphaPlotName().equals(name)){
                return plot;
            }
        }
        return null;
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

    public Role leaderRole(){
        Role r = new Role("leader", 64);
        for(Perm.PERM p : Perm.PERM.values()){
            Perm perm = new Perm(p, 1, 0);

            r.addPermission(perm);
        }

        return r;

    }

    public Town GetTownFromDb(){
        return towns.find(eq("name",name)).first();
    }

}
