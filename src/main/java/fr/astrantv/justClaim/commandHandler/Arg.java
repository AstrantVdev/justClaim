package fr.astrantv.justClaim.commandHandler;

import java.util.ArrayList;

public class Arg {
    private String name;
    private String desc = "Just a lambda argument";
    private TYPES type = TYPES.STRING;
    private Boolean required = true;
    private ArrayList choices = new ArrayList();
    private Integer maxValue;
    public Integer minValue;
    private Integer maxChr;
    private Integer minChr;

    public Arg(String name) {
        this.name = name;
    }

    public Arg setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Arg setType(TYPES type) {
        this.type = type;
        return this;
    }

    public TYPES getType() {
        return type;
    }

    public Arg setRequired(Boolean required) {
        this.required = required;
        return this;
    }

    public Boolean isRequired() {
        return required;
    }

    public Arg addChoice(Object choice) {
        choices.add(choice);
        return this;
    }

    public ArrayList getChoices() {
        return choices;
    }

    public Arg setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public Arg setMinValue(int minValue) {
        this.minValue = minValue;
        return this;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public Arg setMaxChr(int maxChr) {
        this.maxChr = maxChr;
        return this;
    }

    public Integer getMaxChr() {
        return maxChr;
    }

    public Arg setMinChr(int minChr) {
        this.minChr = minChr;
        return this;
    }

    public Integer getMinChr() {
        return minChr;
    }

    enum TYPES{
        INT,
        STRING,
        BOOLEAN
    }

}