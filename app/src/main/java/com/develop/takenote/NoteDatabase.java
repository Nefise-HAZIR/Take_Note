package com.develop.takenote;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

@Database(entities = Note.class,version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),NoteDatabase.class,"note_database").
                    fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class  PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{

        private NoteDao noteDao;

        private PopulateDbAsyncTask(NoteDatabase noteDatabase){

            noteDao=noteDatabase.noteDao();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            noteDao.Insert(new Note("Title 1","Describtion 1"));
            noteDao.Insert(new Note("Title 2","Describtion 2"));
            noteDao.Insert(new Note("Title 3","Describtion 3"));
            noteDao.Insert(new Note("Title 4","Describtion 4"));
            return null;
        }
    }




}
