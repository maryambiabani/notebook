package net.behsazan.appone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.google.android.material.snackbar.Snackbar;

import net.behsazan.appone.database.NoteDBAdapter;
import net.behsazan.appone.model.Note;
import net.behsazan.ppone.R;
import net.behsazan.ppone.databinding.ActivityAddNoteBinding;

import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity {
    ActivityAddNoteBinding binding;
    NoteDBAdapter noteDbAdapter;

    //Date Calender

    Calendar calendar;
    int day = 0;
    int month = 0 ;
    int year = 0;
    String date ="";
    String time ="";
    Bundle bundle;
    int type = 0;
    Note noteEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        noteDbAdapter = new NoteDBAdapter(getApplicationContext());
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);


        bundle = getIntent().getExtras();
        type = bundle.getInt("type");
        if(type==1) {

        }else {
            binding.txtPageTitle.setText("Edit Note");
            noteEdit = bundle.getParcelable("data");
            binding.edtDescription.setText(noteEdit.getDescription());
            binding.edtTitle.setText(noteEdit.getTitle());
            binding.btnTime.setText(noteEdit.getTime());
            binding.btnDate.setText(noteEdit.getDate());
            binding.btnSave.setText("Edit");
        }
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note();
                note.setTitle(binding.edtTitle.getText().toString());
                note.setDescription(binding.edtDescription.getText().toString());
                note.setTime(time);
                note.setDate(date);

                long result = noteDbAdapter.insert(note);

                if(result>0) {

                    Snackbar.make(view  , R.string.add_success , Snackbar.LENGTH_LONG).show();

                }else {
                    Snackbar.make(view  , R.string.add_error , Snackbar.LENGTH_LONG).show();

                }

            }
        });
        binding.btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatePickerDialog dialog = new DatePickerDialog(AddNoteActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                date = i+"/"+i1+"/"+i2;
                                binding.btnDate.setText(date);
                            }
                        },year , month , day);
                dialog.show();

            }
        });

        binding.btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog dialog = new TimePickerDialog(AddNoteActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                time = i+":"+i1;
                                binding.btnTime.setText(time);
                            }
                        },calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true);
                dialog.show();

            }
        });

    }




    }
