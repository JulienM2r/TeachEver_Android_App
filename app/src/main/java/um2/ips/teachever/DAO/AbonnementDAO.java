package um2.ips.teachever.DAO;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import um2.ips.teachever.Entities.Eleve;
import um2.ips.teachever.Entities.Parent;

/**
 * Data access object for Parent.
 */
@Dao
public interface ParentDAO {
    /**
     * Counts the number of Parents in the table.
     *
     * @return The number of Parents.
     */
    @Query("SELECT COUNT(*) FROM " + Parent.TABLE_NAME)
    int count();

    /**
     * Inserts a Parent into the table.
     *
     * @param parent A new Parent.
     * @return The row ID of the newly inserted Parent.
     */
    @Insert
    long insert(Parent parent);

    /**
     * Select all Parents.
     *
     * @return A {@link Cursor} of all the Parents in the table.
     */
    @Query("SELECT * FROM " + Parent.TABLE_NAME)
    Cursor selectAll();

    /**
     * Select a Parent by the Email.
     *
     * @param email The Parent Email.
     * @return A {@link Cursor} of the selected Parent.
     */
    @Query("SELECT * FROM " + Parent.TABLE_NAME + " WHERE " + Parent.COLUMN_Email + " = :email AND " + Parent.COLUMN_Password + " = :password" )
    Parent[] selectParentByEmailandPassword(String email, String password);

    /**
     * Select a Parent by the id.
     *
     * @param id The row id.
     * @return A {@link Cursor} of the selected Parent.
     */
    @Query("SELECT * FROM " + Parent.TABLE_NAME + " WHERE " + Parent.COLUMN_ID + " = :id")
    Parent selectParentById(long id);

    /**
     * Delete a cheese by the ID.
     *
     * @param id The row ID.
     * @return A number of cheeses deleted. This should always be {@code 1}.
     *//*
    @Query("DELETE FROM " + Cheese.TABLE_NAME + " WHERE " + Cheese.COLUMN_ID + " = :id")
    int deleteById(long id);*/

    /**
     * Update the Parent. The Parent is identified by the  email.
     *
     * @param parent The Parent to update.
     * @return A number of Parents updated. This should always be {@code 1}.
     */
    @Update
    int update(Parent parent);

}


