package net.kimleo.prm.components;

public enum Types {
    INTEGER,
    NUMBER,
    STRING,
    FLOAT,
    DECIMAL,
    DATETIME,
    TIMESTAMP,
    TEXT,

    //==== NONE-STANDARD ====
    NAME,
    AGE,
    ADDRESS,

    TABLE_ROW,
    REFERENCE;
    private String referred = null;

    public static Types parse(String type){
        try{
            return Types.valueOf(type.toUpperCase());
        }catch (IllegalArgumentException e){
            return REFERENCE;
        }
    }
    public String refers(){
        return referred;
    }

    public void referTo(String referred) {
        if(this.equals(REFERENCE)){
            this.referred = referred;
        }
    }
}
