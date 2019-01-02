package com.michaelmuratov.warehouse.Engine.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ClassDao {
    @Query("SELECT * FROM Class")
    List<Class> getAll();

    @Query("SELECT * FROM Class WHERE uid IN (:userIds)")
    List<Class> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Class WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    Class findByName(String first, String last);

    @Insert
    void insertAll(Class... new_class);

    @Insert
    void insert(Class new_class);

    @Delete
    void delete(Class this_class);
}