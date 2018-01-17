package com.example.jatinderkumar.staticalertbutton;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.activity_alert_entrt,null);
                builder.setView(view);
                builder.setTitle("AlertBox");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.ic_dashboard);
                builder.setMessage("Thank You");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                        View v1 = getLayoutInflater().inflate(R.layout.secondlayout,null);
                        builder1.setView(v1);
                        final EditText editText = (EditText) v1.findViewById(R.id.editText);
                        final EditText editText1 =(EditText)v1.findViewById(R.id.editText2);
                        builder1.setTitle("New AlertBox");
                        builder1.setMessage("Thank You");
                        builder1.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String  s = editText.getText().toString();
                                String s1 = editText1.getText().toString();
                                Toast.makeText(MainActivity.this,"You entered "+s+ "-----"+ s1+"",Toast.LENGTH_LONG).show();



                            }
                        });
                        builder1.create();
                        builder1.show();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                      //  View v1 = getLayoutInflater().inflate(R.layout.multichoic,null);
                      //  builder1.setView(v1);

                        builder1.setCancelable(false);
                        boolean[] items  ={true,false,true,false};

                        builder1.setMultiChoiceItems(R.array.checkbox, items, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_LONG).show();

                            }
                        });
                        }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_LONG).show();
                    }
                });
                builder.create();
                builder.show();

            }
        });
    }
}
