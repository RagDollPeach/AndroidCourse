package com.example.mynotepad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Note> notesList;

    public MyAdapter(Context context, List<Note> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.note_view, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note note = notesList.get(position);
        holder.titleOutput.setText(note.getName());
        holder.noteOutput.setText(note.getNote());

        String formatedTime = DateFormat.getDateTimeInstance().format(note.getDate());
        holder.timeOutput.setText(formatedTime);

        holder.itemView.setOnLongClickListener(view -> {
            PopupMenu menu = new PopupMenu(context, view);
            menu.getMenu().add("Удалить");
            menu.setOnMenuItemClickListener(menuItem -> {
                if (menuItem.getTitle().equals("Удалить")) {
                    CreateNoteFragment.notesList.remove(position);
                    Toast.makeText(context, "Заметка удалена", Toast.LENGTH_SHORT).show();
                }
                return true;
            });
            menu.show();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleOutput;
        TextView noteOutput;
        TextView timeOutput;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleOutput = itemView.findViewById(R.id.note_title_output);
            noteOutput = itemView.findViewById(R.id.note_output);
            timeOutput = itemView.findViewById(R.id.note_time_output);
        }
    }

}
