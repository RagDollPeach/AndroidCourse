package com.example.mynotepad.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotepad.R;
import com.example.mynotepad.adpter.NoteAdapter;
import com.example.mynotepad.data.NotesDataSource;
import com.example.mynotepad.interfaces.INotesDataSource;
import com.example.mynotepad.interfaces.RvOnClickListener;
import com.example.mynotepad.pojo.Note;
import com.google.gson.GsonBuilder;

import java.util.HashSet;
import java.util.Set;

public class NotesFragment extends Fragment implements RvOnClickListener {

    private CreateNoteFragment fragment;
    private final INotesDataSource dataSource = NotesDataSource.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toolbar toolbar = requireActivity().findViewById(R.id.tool_bar);
        toolbar.setTitle("Заметки");
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatButton newNoteButton = view.findViewById(R.id.new_note_button);
        fragment = new CreateNoteFragment();
        RecyclerView recyclerView = view.findViewById(R.id.recycler);

        SharedPreferences pref = requireActivity()
                .getSharedPreferences(LoginFragment.loginKey + "prefs", Context.MODE_PRIVATE);
        Set<String> notesList = new HashSet<>();
        if (!dataSource.getNotesList().isEmpty()) {
            for (Note note : dataSource.getNotesList()) {
                String notePref = new GsonBuilder().create().toJson(note);
                notesList.add(notePref);
            }
            pref.edit().putStringSet(LoginFragment.loginKey + "prefs", notesList).apply();
        }

        if (dataSource.getNotesList().isEmpty()) {
            for (String str : pref.getStringSet(LoginFragment.loginKey + "prefs", notesList)) {
                Note note = new GsonBuilder().create().fromJson(str, Note.class);
                dataSource.addNote(note);
            }
        }
        newNoteButton.setOnClickListener(view1 -> enableFragment(fragment));

        NoteAdapter adapter = new NoteAdapter();
        adapter.setNotesList(dataSource.getNotesList());
        adapter.setRvOnClickListener(NotesFragment.this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.post(() -> recyclerView.smoothScrollToPosition(adapter.getItemCount()));
    }

    private void enableFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack("fragment_create_note")
                .commit();
    }

    @Override
    public void switchFragment(Note note) {
        CreateNoteFragment fragment = new CreateNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("note", note);
        fragment.setArguments(bundle);
        enableFragment(fragment);
    }
}