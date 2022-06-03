package com.example.mynotepad.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotepad.R;
import com.example.mynotepad.RvOnClickListener;
import com.example.mynotepad.adpter.NoteAdapter;
import com.example.mynotepad.pojo.Note;

public class NotesFragment extends Fragment implements RvOnClickListener{

    private RvOnClickListener rvOnClickListener;
    private CreateNoteFragment fragment;

    public void setRvOnClickListener(RvOnClickListener rvOnClickListener) {
        this.rvOnClickListener = rvOnClickListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatButton newNoteButton = view.findViewById(R.id.new_note_button);
        fragment = new CreateNoteFragment();
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        setRvOnClickListener(NotesFragment.this);

        newNoteButton.setOnClickListener(view1 -> enableFragment(fragment, "fragment_create_note"));

        NoteAdapter notesAdapter = new NoteAdapter(rvOnClickListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(notesAdapter);

    }

    public void enableFragment(Fragment note, String fragmentName) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, note)
                .addToBackStack(fragmentName)
                .commit();
    }

    @Override
    public void switchFragment(Note note) {
        enableFragment(fragment,"fragment_create_note");
    }
}