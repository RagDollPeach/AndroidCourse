package com.example.mynotepad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesFragment extends Fragment {

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
        CreateNoteFragment fragment = new CreateNoteFragment();
        RecyclerView recyclerView = view.findViewById(R.id.recycler);

        newNoteButton.setOnClickListener(view1 -> enableFragment(fragment, "fragment_create_note"));
        List<Note> notes = CreateNoteFragment.notesList;

        MyAdapter myAdapter = new MyAdapter(getContext(), notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myAdapter);

    }

    public void enableFragment(Fragment note, String fragmentName) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, note)
                .addToBackStack(fragmentName)
                .commit();
    }
}