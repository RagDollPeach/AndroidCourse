package com.example.mynotepad.adpter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotepad.R;
import com.example.mynotepad.intefaces.RvOnClickListener;
import com.example.mynotepad.pojo.Note;

import java.text.DateFormat;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> notesList;
    private RvOnClickListener rvOnClickListener;

    public void setNotesList(List<Note> notesList) {
        this.notesList = notesList;
    }

    public void setRvOnClickListener(RvOnClickListener rvOnClickListener) {
        this.rvOnClickListener = rvOnClickListener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notesList.get(position);
        holder.titleOutput.setText(note.getTitle());
        holder.noteOutput.setText(note.getNote());

        String formatedTime = DateFormat.getDateTimeInstance().format(note.getDate());
        holder.timeOutput.setText(formatedTime);

        holder.itemView.setOnLongClickListener(view -> {
            PopupMenu menu = new PopupMenu(view.getContext(), view);
            menu.getMenu().add("Удалить");
            menu.getMenu().add("Удалить все заметки");
            menu.setOnMenuItemClickListener(menuItem -> {
                if (menuItem.getTitle().equals("Удалить")) {
                    alertDialogForDeleteNote(view.getContext(), position);
                }
                if (menuItem.getTitle().equals("Удалить все заметки")) {
                    alertDialogForDeleteAllNote(view.getContext());
                }
                return true;
            });
            menu.show();
            return true;
        });
    }

    private void alertDialogForDeleteNote(Context context, int position) {
        new AlertDialog.Builder(context)
                .setTitle("Удаление заметки")
                .setMessage("Вы действительно хотите удалить эту заметку?")
                .setIcon(R.drawable.star)
                .setCancelable(false)
                .setPositiveButton("Да", (dialogInterface, i) -> {
                    Toast.makeText(context, "Заметка удалена", Toast.LENGTH_SHORT).show();
                    notesList.remove(position);
                    notifyItemRemoved(position);
                })
                .setNegativeButton("Нет", (dialogInterface, i)
                        -> Toast.makeText(context, "Заметка не удалена", Toast.LENGTH_SHORT).show())
                .show();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void alertDialogForDeleteAllNote(Context context) {
        new AlertDialog.Builder(context)
                .setTitle("Удаление всех заметок")
                .setMessage("Вы действительно хотите удалить все заметки?")
                .setCancelable(false)
                .setPositiveButton("Да", (dialogInterface, i) -> {
                    Toast.makeText(context, "Заметки удалены", Toast.LENGTH_SHORT).show();
                    notesList.clear();
                    notifyDataSetChanged();
                })
                .setNegativeButton("Нет", (dialogInterface, i)
                        -> Toast.makeText(context, "Заметки не удалены", Toast.LENGTH_SHORT).show())
                .show();
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView titleOutput;
        TextView noteOutput;
        TextView timeOutput;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(view ->
                    rvOnClickListener.switchFragment(notesList.get(getAdapterPosition())));

            titleOutput = itemView.findViewById(R.id.note_title_output);
            noteOutput = itemView.findViewById(R.id.note_output);
            timeOutput = itemView.findViewById(R.id.note_time_output);
        }
    }
}
