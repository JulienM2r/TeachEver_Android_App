package um2.ips.teachever.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import um2.ips.teachever.DAO.AbonnementDAO;
import um2.ips.teachever.DAO.CoursDAO;
import um2.ips.teachever.DAO.ParentDAO;
import um2.ips.teachever.Entities.Abonnement;
import um2.ips.teachever.Entities.Cours;
import um2.ips.teachever.Entities.Eleve;
import um2.ips.teachever.DAO.EleveDAO;
import um2.ips.teachever.Entities.Parent;
import um2.ips.teachever.MyApp;


/**
 * The Room database.
 */
@Database(entities = {Eleve.class, Abonnement.class, Parent.class, Cours.class}, version = 1)
public abstract class SampleDatabase extends RoomDatabase {
    private static SampleDatabase INSTANCE;
    private static final String DB_NAME = "TeachEverDb1";
    /**
     * @return The DAO for the Eleve table.
     */
    @SuppressWarnings("WeakerAccess")
    public abstract EleveDAO eleve();
    /**
     * @return The DAO for the Abonnement table.
     */
    @SuppressWarnings("WeakerAccess")
    public abstract AbonnementDAO abo();
    /**
     * @return The DAO for the Parent table.
     */
    @SuppressWarnings("WeakerAccess")
    public abstract ParentDAO parent();
    /**
     * @return The DAO for the Cours table.
     */
    @SuppressWarnings("WeakerAccess")
    public abstract CoursDAO cours();



    /** The only instance *//*
    private static SampleDatabase sInstance;*/

    /**
     * Gets the singleton instance of SampleDatabase.
     *
     * @param context The context.
     * @return The singleton instance of SampleDatabase.
     */
    public static SampleDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (SampleDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(MyApp.getInstance().getApplicationContext(),
                            SampleDatabase.class, DB_NAME)
                            .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                            .fallbackToDestructiveMigration()
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Log.d("TeachEverDatabase", "populating with data...");
                                    new populateInitialData(INSTANCE).execute();
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /*public static synchronized SampleDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room
                    .databaseBuilder(context.getApplicationContext(), SampleDatabase.class, DB_NAME)
                    .build();
            sInstance.populateInitialData();
        }
        return sInstance;
    }*/

    /**
     * Switches the internal implementation with an empty in-memory database.
     *
     * @param context The context.
     */
    @VisibleForTesting
    public static void switchToInMemory(Context context) {
        INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                SampleDatabase.class).build();

    }

    /**
     * Inserts the test data into the database if it is currently empty.
     */
    private static class populateInitialData extends AsyncTask<Void, Void, Void> {
        EleveDAO eleveDao;
        ParentDAO parentDao;
        AbonnementDAO aboDao;
        CoursDAO coursDao;
        //private final DirectorDao directorDao;
        public populateInitialData(SampleDatabase instance) {
            eleveDao = instance.eleve();
            parentDao = instance.parent();
            aboDao = instance.abo();
            coursDao = instance.cours();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            eleveDao.deleteAll();
            parentDao.deleteAll();
            aboDao.deleteAll();
            coursDao.deleteAll();

            Eleve eleve1 = new Eleve("EleveNom", "ElevePrenom", "maile1@test.fr", "PasswordTest", "5eme");
            Parent parent1 = new Parent("ParentNom", "ParentPrenom", "mailp1@test.fr", "test");
            Abonnement aboM = new Abonnement("Mensuel", 1, 24.99);
            Abonnement aboA = new Abonnement("Annuel", 12, 199.99);
            Cours cours1 = new Cours("Somme et différence", "Cinquieme", "Mathematique", "Dans cet exercice, le professeur va nous expliquer la somme et la différence. La somme de deux nombres a et b est notée a + b ou bien on peut inverser b + a. La différence de deux nombres a et b est notée a – b lorsque a > b. Il faut que le 1er nombre soit plus grand que le 2eme nombre. Les nombres a et b que l’on ajoute ou que l’on soustrait s’appellent des termes. Ça c’est uniquement pour l’addition et la soustraction.", "sommeetdifference5eme.mp4");

            final long IdEleve1 = eleveDao.insert(eleve1);
            final long IdParent1 = parentDao.insert(parent1);
            final long IdAbo1 = aboDao.insert(aboM);
            final long IdAbo2 = aboDao.insert(aboA);
            final long IdCours1 = coursDao.insert(cours1);
            eleve1.setAbonnement(aboM.getType());
            eleveDao.update(eleve1);


            /*Director directorOne = new Director("Adam McKay");
            Director directorTwo = new Director("Denis Villeneuve");
            Director directorThree = new Director("Morten Tyldum");
            Movie movieOne = new Movie("The Big Short", (int) directorDao.insert(directorOne));*/
            /*final int dIdTwo = (int) directorDao.insert(directorTwo);
            Movie movieTwo = new Movie("Arrival", dIdTwo);
            Movie movieThree = new Movie("Blade Runner 2049", dIdTwo);
            Movie movieFour = new Movie("Passengers", (int) directorDao.insert(directorThree));
            movieDao.insert(movieOne, movieTwo, movieThree, movieFour);*/
            return null;
        }

    }

}
