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

    private CreateNoteFragment fragment;

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

        newNoteButton.setOnClickListener(view1 -> enableFragment(fragment, "fragment_create_note"));

        NoteAdapter adapter = new NoteAdapter();
        adapter.setNotesList(CreateNoteFragment.notesList);
        adapter.setRvOnClickListener(NotesFragment.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }

    public void enableFragment(Fragment fragment, String fragmentName) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(fragmentName)
                .commit();
    }


    @Override
    public void switchFragment(Note note) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("note",note);
        this.setArguments(bundle);
        enableFragment(fragment,"fragment_create_note");
    }
}