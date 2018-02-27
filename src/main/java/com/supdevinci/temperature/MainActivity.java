package com.supdevinci.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    //Déclaration des propriétés
    EditText  editTextCelcius, editTextFarhremeit;
    Button    buttonSave;
    ListView  ListViewTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelcius = findViewById(R.id.editTextCelcius);
        editTextFarhremeit = findViewById(R.id.editTextFarehneit);
        

        setContentView();
    }
}
