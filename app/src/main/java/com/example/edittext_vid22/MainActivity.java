package com.example.edittext_vid22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //se declaran variables para el EditText
    private EditText etn, etp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    etn = (EditText)findViewById(R.id.txt_nombre);
    etp = (EditText)findViewById(R.id.txt_Pass);

    }

    //Metodo para el botón
    public void Registrar(View view){
    String nombre = etn.getText().toString();
    String password = etp.getText().toString();

    if((nombre.length()== 0) && (password.length() == 0)) {
            Toast.makeText(this, "Debe rellenar los campos no sea imbécil",Toast.LENGTH_LONG).show();
        }
    else if(nombre.length() == 0){
        Toast.makeText(this,"Debes ingresar un Nombre en el campo", Toast.LENGTH_SHORT).show();
    }else if(password.length() == 0){
        Toast.makeText(this, "Debes ingresar una contraseña en el campo contraseña",Toast.LENGTH_SHORT).show();
    }
    else
        {
        Toast.makeText(this,"Registro en Proceso",Toast.LENGTH_SHORT).show();
            Intent siguiente = new Intent(this, SecondActivity.class);
            siguiente.putExtra("nombre", nombre);
            startActivity(siguiente);
    }

    }
}