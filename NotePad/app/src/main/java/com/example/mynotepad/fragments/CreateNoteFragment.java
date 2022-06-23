package com.example.mynotepad.fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mynotepad.R;
import com.example.mynotepad.data.NotesDataSource;
import com.example.mynotepad.interfaces.INotesDataSource;
import com.example.mynotepad.pojo.Note;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class CreateNoteFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private EditText title;
    private EditText text;
    private final INotesDataSource dataSource = NotesDataSource.getInstance();

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
        MaterialButton dateButton = view.findViewById(R.id.date_button);
        MaterialButton saveButton = view.findViewById(R.id.save_button);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Note bundleNote = bundle.getParcelable("note");
            title.setText(bundleNote.getTitle());
            text.setText(bundleNote.getNote());

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
                    dataSource.removeNote(bundleNote);
                    dataSource.addNote(note);

                    Snackbar.make(view, "Заметка записана", Snackbar.LENGTH_SHORT)
                            .setAction("push me", view2 -> Toast.makeText(view2.getContext()
                                    , "Thank you", Toast.LENGTH_SHORT).show()).show();
                    hideKeyboard(requireActivity());
                    enableFragment(new NotesFragment());
                }
            });
        } else {
            saveButton.setOnClickListener(view1 -> {
                String textTitle = title.getText().toString();
                String textNote = text.getText().toString();
                long createdTime = System.currentTimeMillis();

                if (textTitle.equals("")) {
                    textTitle = "No title";
                }
                if (textNote.equals("")) {
                    Toast.makeText(getContext(), "Напишите заметку", Toast.LENGTH_SHORT).show();
                } else {
                    Note note = new Note(textTitle, textNote, createdTime);
                    dataSource.addNote(note);

                    Snackbar.make(view, "Заметка записана", Snackbar.LENGTH_LONG)
                            .setAction("push me", view2 -> Toast.makeText(view2.getContext()
                                    , "Thank you", Toast.LENGTH_SHORT).show()).show();

                    hideKeyboard(requireActivity());
                    enableFragment(new NotesFragment());
                }
            });
        }

        dateButton.setOnClickListener(v -> datePickerDialog());
    }

    @Override
    public void onDestroyView() {
        hideKeyboard(requireActivity());
        super.onDestroyView();
    }

    private static void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        View currentFocusedView = activity.getCurrentFocus();
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private void datePickerDialog() {
        new DatePickerDialog(
                requireContext(),
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String date = text.getText().toString() + day + "/" + month + "/" + year;
        text.setText(date);
        text.setSelection(text.getText().length());
    }

    private void enableFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack("fragment_create_note")
                .commit();
    }
}