package net.behsazan.appone;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import net.behsazan.appone.adapter.ToDoRecyclerAdapter;
import net.behsazan.appone.database.NoteDBAdapter;
import net.behsazan.appone.database.NoteDatabase;
import net.behsazan.appone.model.Note;
import net.behsazan.ppone.R;

import java.util.List;


public class TodoFragment extends Fragment {

    FloatingActionButton fab_add;
    RecyclerView recycler_notes;
    NoteDatabase noteDatabase ;
    NoteDBAdapter noteDbAdapter;



    public TodoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_todo, container, false);
        noteDbAdapter=new NoteDBAdapter(view.getContext());
        fab_add=view.findViewById(R.id.fab_add);
        recycler_notes=view.findViewById(R.id.recycler_notes);

        List<Note> noteList = noteDbAdapter.getNotesList();
        Log.e("","");
        ToDoRecyclerAdapter adapter = new ToDoRecyclerAdapter(view.getContext() , noteList);
        recycler_notes.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL,false);
        recycler_notes.setLayoutManager(manager);



        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext() , AddNoteActivity.class);
                intent.putExtra("type",1);
                intent.putExtra("flag",1);
                startActivity(intent);

            }
        });


        return view;
    }


}