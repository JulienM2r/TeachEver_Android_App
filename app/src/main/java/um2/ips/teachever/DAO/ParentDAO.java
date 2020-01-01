package um2.ips.teachever.DAO;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import um2.ips.teachever.Entities.Eleve;

/**
 * Data access object for Eleve.
 */
@Dao
public interface EleveDAO {
    /**
     * Counts the number of Eleves in the table.
     *
     * @return The number of Eleves.
     */
    @Query("SELECT COUNT(*) FROM " + Eleve.TABLE_NAME)
    int count();

    /**
     * Inserts a Eleve into the table.
     *
     * @param eleve A new Eleve.
     * @return The row ID of the newly inserted Eleve.
     */
    @Insert
    long insert(Eleve eleve);

    /**
     * Select all Eleves.
     *
     * @return A {@link Cursor} of all the Eleves in the table.
     */
    @Query("SELECT * FROM " + Eleve.TABLE_NAME)
    Cursor selectAll();

    /**
     * Select a Eleve by the Email.
     *
     * @param email The Eleve Email.
     * @return A {@link Cursor} of the selected Eleve.
     */
    @Query("SELECT * FROM " + Eleve.TABLE_NAME + " WHERE " + Eleve.COLUMN_Email + " = :email AND " + Eleve.COLUMN_Password + " = :password" )
    Eleve[] selectEleveByEmailandPassword(String email, String password);

    /**
     * Select a Eleve by the id.
     *
     * @param id The row id.
     * @return A {@link Cursor} of the selected Eleve.
     */
    @Query("SELECT * FROM " + Eleve.TABLE_NAME + " WHERE " + Eleve.COLUMN_ID + " = :id")
    Eleve selectEleveById(long id);

    /**
     * Delete a cheese by the ID.
     *
     * @param id The row ID.
     * @return A number of cheeses deleted. This should always be {@code 1}.
     *//*
    @Query("DELETE FROM " + Cheese.TABLE_NAME + " WHERE " + Cheese.COLUMN_ID + " = :id")
    int deleteById(long id);*/

    /**
     * Update the eleve. The eleve is identified by the  email.
     *
     * @param eleve The Eleve to update.
     * @return A number of eleves updated. This should always be {@code 1}.
     */
    @Update
    int update(Eleve eleve);

}


