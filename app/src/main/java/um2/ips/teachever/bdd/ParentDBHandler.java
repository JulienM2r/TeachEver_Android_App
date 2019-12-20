package um2.ips.teachever.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ParentDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "TeachDatabase";

    public ParentDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlparent = "CREATE TABLE parents " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstname TEXT, " +
                "lastname TEXT, " +
                "email TEXT, " +
                "password TEXT);"
                ;
        String sqlEleve = "CREATE TABLE eleves " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstname TEXT, " +
                "lastname TEXT, " +
                "email TEXT, " +
                "password TEXT, " +
                "annee_scolaire TEXT);"
                ;


        db.execSQL(sqlparent);
        db.execSQL(sqlEleve);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sqlp = "DROP TABLE IF EXISTS parents";
        String sqle = "DROP TABLE IF EXISTS eleves";
        db.execSQL(sqlp);
        db.execSQL(sqle);

        onCreate(db);
    }

}
