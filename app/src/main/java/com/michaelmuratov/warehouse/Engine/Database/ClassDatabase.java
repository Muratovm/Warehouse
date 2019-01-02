package com.michaelmuratov.warehouse.Engine.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;


@Database(entities = {Class.class}, version = 3)
@TypeConverters({Converters.class})

public abstract class ClassDatabase extends RoomDatabase {
    public abstract ClassDao userDao();
}
