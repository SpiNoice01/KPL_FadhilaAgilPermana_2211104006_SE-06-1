from enum import enum

public enum stateProduk {MenungguProduk, MengeluarkanProduk, Selesai};
Public enum Trigger {MemasukanUang, PilihProduk, MengeluarkanProduk};

class trasnsition {
    public stateProduk prevstate;
    public stateProduk nextstate;
    public Trigger trigger;

    public trasnsition(stateProduk prevstate, stateProduk nextstate, Trigger trigger) { 
}}