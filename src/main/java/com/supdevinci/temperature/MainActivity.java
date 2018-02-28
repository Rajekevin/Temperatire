package com.supdevinci.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import  android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.supdevinci.temperature.Temperature.TemperatureConvert;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Déclaration des propriétés
    EditText editTextCelcius, editTextFarhremeit;
    Button buttonSaveS;
    ListView ListViewTemperature;

    List<String> stringList = new ArrayList<>();
    private ArrayAdapter<String> adapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.settings, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelcius     = findViewById(R.id.editTextCelcius);
        editTextFarhremeit  = findViewById(R.id.editTextFarehneit);
        buttonSaveS         = findViewById(R.id.buttonSaveS);
        ListViewTemperature = findViewById(R.id.ListViewTemperature);

        stringList = new ArrayList<String>();


        adapter = new ArrayAdapter<String>(MainActivity.this,
        android.R.layout.simple_list_item_1, stringList);

        ListViewTemperature.setAdapter(adapter);

      /*  ListViewTemperature.setAdapter(new ArrayAdapter<String>(MainActivity.this,
        android.R.layout.simple_list_item_1, stringList ) );*/
        buttonSaveS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringList.add(editTextCelcius.getText().toString() + "="+ editTextFarhremeit.getText().toString());

                //Refraichissement de la liste
                adapter.notifyDataSetChanged();
            }
        });




        ListViewTemperature.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                stringList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });


        editTextCelcius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Récupération valeur
                String valeur = editable.toString();

                 if(valeur.length() > 0 && isNumeric(valeur) && isNumeric(valeur) && editTextCelcius.hasFocus() )
                 {
                     Double valeurDouble = Double.valueOf(valeur);
                     String resultat = TemperatureConvert.convertCelsiusToFahrenheit(valeurDouble);
                     editTextFarhremeit.setText(String.valueOf(resultat));
                 }
            }
        });

        editTextFarhremeit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String valeur = s.toString();

                if(valeur.length()>0 && isNumeric(valeur) && editTextFarhremeit.hasFocus()) {
                    Double valeurDouble = Double.valueOf(valeur);

                    String resultat = TemperatureConvert.convertFahrenheitToCelsius(valeurDouble);
                    editTextCelcius.setText(String.valueOf(resultat));

                }


            }
        });

    }
    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }


}
