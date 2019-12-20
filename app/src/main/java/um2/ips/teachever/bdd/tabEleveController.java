package um2.ips.teachever.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import um2.ips.teachever.Entities.Eleve;
import um2.ips.teachever.Entities.Parent;

public class tabEleveController extends ParentDBHandler {

    public tabEleveController(Context context) {
        super(context);
    }

    public boolean create(Eleve eleve) {

        ContentValues values = new ContentValues();

        values.put("firstname", eleve.getPrenom());
        values.put("lastname", eleve.getNom());
        values.put("email", eleve.getEmail());
        values.put("password", eleve.getPassword());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("eleves", null, values) > 0;
        db.close();

        return createSuccessful;
    }
    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM eleves";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;

    }
}
