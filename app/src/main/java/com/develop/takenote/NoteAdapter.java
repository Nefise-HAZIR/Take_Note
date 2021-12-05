package com.develop.takenote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes=new ArrayList<>();


    @NonNull
    @NotNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        return new NoteHolder(view);
    }



    @Override
    public void onBindViewHolder( @NotNull NoteHolder holder, int position) {

        Note currentNote=notes.get(position);
        holder.title.setText(currentNote.getTitle());
        holder.describtion.setText(currentNote.getDescribtion());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static void setNotes(List<Note> notes){
        this.notes=notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder{

        public TextView title;
        private TextView describtion;

        public NoteHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.textViewTitle);
            describtion=itemView.findViewById(R.id.textViewDescribtion);
        }
    }
}
