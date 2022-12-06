package fr.astrantv.justClaim.handler;

import java.util.ArrayList;

public class Arg {
    public String name;
    public String desc = "";
    public TYPES type = TYPES.STRING;
    public Boolean required = true;
    public ArrayList choices = new ArrayList();
    public Integer maxValue;
    public Integer minValue;
    public Integer maxChr;
    public Integer minChr;
    enum TYPES{
        INT,
        STRING,
        BOOLEAN
    }

}