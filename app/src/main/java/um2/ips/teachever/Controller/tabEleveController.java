package um2.ips.teachever.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import um2.ips.teachever.DAO.EleveDAO;
import um2.ips.teachever.Entities.Parent;
import um2.ips.teachever.bdd.SampleDatabase;

public class tabParentController extends SampleDatabase {

    public tabParentController(Context context) {
        super(context);
    }

    public boolean create(Parent parent) {

        ContentValues values = new ContentValues();

        values.put("firstname", parent.getPrenom());
        values.put("lastname", parent.getNom());
        values.put("email", parent.getEmail());
        values.put("password", parent.getPassword());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("parents", null, values) > 0;
        db.close();

        return createSuccessful;
    }
    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM parents";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;

    }

    @Override
    public EleveDAO eleve() {
        return eleve().;
    }
}
