package net.behsazan.appone.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import net.behsazan.appone.AddNoteActivity;
import net.behsazan.appone.database.NoteDBAdapter;
import net.behsazan.appone.model.Note;
import net.behsazan.ppone.R;

import java.util.List;

public class ToDoRecyclerAdapter extends RecyclerView.Adapter<ToDoRecyclerAdapter.ToDoVH> {

    List<Note> noteList;
    Context context;
    LayoutInflater inflater;
    NoteDBAdapter noteDbAdapter;

    public ToDoRecyclerAdapter(Context context, List<Note> noteList){
    this.context=context;
    this.noteList=noteList;
        inflater = LayoutInflater.from(context);
        noteDbAdapter = new NoteDBAdapter(context);

}

    @NonNull
    @Override
    public ToDoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.note_row , null);
        return new ToDoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoVH holder, @SuppressLint("RecyclerView") int position) {
        Note note = noteList.get(position);
        holder.txt_title.setText(note.getTitle());
        holder.txt_description.setText(note.getDescription());

        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                noteList.remove(position);
                noteDbAdapter.deleteNoteById(note.getId());
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, noteList.size());
            }
        });
        holder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , AddNoteActivity.class);
                intent.putExtra("type" , 2);
                intent.putExtra("data", note);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
        holder.img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                /*This will be the actual content you wish you share.*/
                String shareBody = note.getDescription();
                /*The type of the content is text, obviously.*/
                intent.setType("text/plain");
                /*Applying information Subject and Body.*/
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, note.getTitle());
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(intent, "Share"));

            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class ToDoVH extends RecyclerView.ViewHolder{

        AppCompatTextView txt_title,txt_description;
        AppCompatImageView img_delete;
        AppCompatImageView img_share;
        AppCompatImageView img_edit;
        public ToDoVH(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_description = itemView.findViewById(R.id.txt_description);
            img_delete = itemView.findViewById(R.id.img_delete);
            img_share = itemView.findViewById(R.id.img_share);
            img_edit = itemView.findViewById(R.id.img_edit);
        }
    }
    }

