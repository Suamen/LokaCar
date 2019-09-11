package com.example.lokacar.data.bo;

public abstract class DataContract {
    public final static String DATABASE_NAME = "LokaCar.db";
    public final static int DATABASE_VERSION = 1;

    public final static String COL_ID = "ID";
    public final static String COL_NOM = "NOM";
    public final static String COL_ADRESSE = "ADRESSE";

    // table Gérant
    public final static String NOM_TABLE_GERANT = "Gerant";
    public final static String COL_PRENOM = "PRENOM";
    public final static String COL_TEL = "TEL";
    public final static String COL_EMAIL = "EMAIL";
    public final static String COL_LOGIN = "LOGIN";
    public final static String COL_MDP = "MDP";
    public final static String CREATE_TABLE_GERANT =
            "CREATE TABLE IF NOT EXISTS "
                    + NOM_TABLE_GERANT + " ("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NOM + " TEXT, "
                    + COL_PRENOM + " TEXT, "
                    + COL_ADRESSE + " TEXT, "
                    + COL_TEL + " TEXT, "
                    + COL_EMAIL + " TEXT, "
                    + COL_LOGIN + " TEXT ,"
                    + COL_MDP + " TEXT)";

    // table Agence
    public final static String NOM_TABLE_AGENCE = "Agence";
    public final static String COL_GERANT = "GERANT";
    public final static String CREATE_TABLE_AGENCE =
            "CREATE TABLE IF NOT EXISTS "
                    + NOM_TABLE_AGENCE + " ("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NOM + " TEXT, "
                    + COL_ADRESSE + " TEXT, "
                    + COL_GERANT + " INTEGER, "
                    + "FOREIGN KEY (" + COL_GERANT + ") REFERENCES " + NOM_TABLE_GERANT + "(" + COL_ID + "))";

    // Destruction d'une table
    public final static String QUERY_DELETE_TABLE = "DROP TABLE IF EXISTS ";


    // table Vehicule
    public final static String NOM_TABLE_VEHICULE = "Vehicule";
    public final static String _IMMATRICULATION = "immatriculation";
    public final static String _MARQUE = "marque";
    public final static String _PHOTO_VEHICULE = "photoVehicule";
    public final static String _KILOMETRAGE = "kilometrage";
    public final static String _IS_LOUE = "isLoue";
    public final static String _IS_DISPONIBLE = "isDisponible";
    public final static String _ID_AGENCE = "idAgence";

    public final static String CREATE_TABLE_VEHICULE =
            "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_VEHICULE + " ("
                    + _IMMATRICULATION + " text NOT NULL PRIMARY KEY, "
                    + _MARQUE + " text, "
                    + _PHOTO_VEHICULE + " text, "
                    + _KILOMETRAGE + " integer, "
                    + _IS_LOUE + " integer NOT NULL DEFAULT 0, "
                    + _IS_DISPONIBLE + " integer NOT NULL DEFAULT 0, "
                    + _ID_AGENCE + " integer NOT NULL, "
                    + "FOREIGN KEY (" + _ID_AGENCE + ") REFERENCES " + NOM_TABLE_AGENCE + "(" + COL_ID + ") "
                    + ")";

}
