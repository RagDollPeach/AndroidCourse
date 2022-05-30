package com.example.mynotepad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
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
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_create_note, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.menu_find);
        if (item != null) {
            item.setVisible(false);
        }
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
                Collections.sort(notesList);
                Toast.makeText(getContext(), "Заметка записана", Toast.LENGTH_SHORT).show();
                hideKeyboard(requireActivity());
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        View currentFocusedView = activity.getCurrentFocus();
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}