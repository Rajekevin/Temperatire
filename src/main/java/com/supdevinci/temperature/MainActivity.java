package com.supdevinci.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    //Déclaration des propriétés
    EditText editTextCelcius, editTextFarhremeit;
    Button buttonSaveS;
    ListView ListViewTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelcius = findViewById(R.id.editTextCelcius);
        editTextFarhremeit = findViewById(R.id.editTextFarehneit);
        buttonSaveS = findViewById(R.id.buttonSaveS);
        ListViewTemperature = findViewById(R.id.ListViewTemperature);

         editTextCelcius.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void afterTextChanged(Editable editable) {

                 Double resultat =0.0;
                 editTextFarhremeit.setText(String.valueOf(resultat));

               /*  String valeur = editable.ToString();
                 editTextFarhremeit.setText(valeur);*/

             }
         });

        //setContentView();
    }
}
