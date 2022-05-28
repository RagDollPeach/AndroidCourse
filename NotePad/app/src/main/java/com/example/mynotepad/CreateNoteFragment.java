package com.example.mynotepad;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CreateNoteFragment extends Fragment {

    public static List<Note> notesList = new ArrayList<>();
    private EditText title;
    private EditText text;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.title_input);
        text = view.findViewById(R.id.note_input);
        AppCompatButton saveButton = view.findViewById(R.id.save_button);
        saveButton.setOnClickListener(view1 -> {
            String textTitle = title.getText().toString();
            String textNote = text.getText().toString();
            long createdTime = System.currentTimeMillis();
            if (textTitle.equals("")) {
                textTitle = "без названия...";
            }
            if (textNote.equals("")) {
                Toast.makeText(getContext(), "Напишите заметку", Toast.LENGTH_SHORT).show();
            } else {
                Note note = new Note(textTitle, textNote, createdTime);
                notesList.add(note);
                Toast.makeText(getContext(), "Заметка записана", Toast.LENGTH_SHORT).show();
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }
}