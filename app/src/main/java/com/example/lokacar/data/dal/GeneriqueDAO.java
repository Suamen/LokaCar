package com.example.lokacar.data.dal;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

public interface GeneriqueDAO<T> {
    @Insert
    void insert(T object);

    @Insert
    void insertList(List<T> objects);

    @Update
    void update(T object);

    @Delete
    void delete(T object);
}
