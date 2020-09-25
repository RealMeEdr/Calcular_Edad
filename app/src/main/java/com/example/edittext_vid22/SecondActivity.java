package com.example.edittext_vid22;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;

import java.util.Calendar;
import java.util.Date;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mostrar_nombre, fechaa, fechanac,edad;
    Button fecha;
    Date Fecha_act= new Date();

    int aa =0, ma = 0, anio = 0, mes = 0, dia = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mostrar_nombre = (TextView)findViewById(R.id.tv1);

        String dato = getIntent().getStringExtra("nombre");
        mostrar_nombre.setText("Bienvenid@: \n"+ dato);

        //Aqui se declaran las variables para el calend

        fecha = (Button)findViewById(R.id.btnCalc_Fecha);
        fechaa = (TextView)findViewById(R.id.txt_Fechaact);
        fechanac = (TextView)findViewById(R.id.txt_Fecha_nac);
        edad = (TextView)findViewById(R.id.txt_Edad);
        fecha.setOnClickListener(this);
    }


    public void Regresar(View view){
        Intent regresar = new Intent(this, MainActivity.class);
        startActivity(regresar);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnCalc_Fecha){
            Calendar ca = Calendar.getInstance();
            anio = ca.get(Calendar.YEAR);
            mes = ca.get(Calendar.MONTH);
            int dia = ca.get(Calendar.DAY_OF_MONTH);
            fechaa.setText("Fecha Actual: " +dia+" / "+(mes+1)+" / "+anio);
            DatePickerDialog recogerFecha =  new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int año, int mesi, int diaa) {
                    final int mesActual = mesi +1;
                    String diaFormato = (diaa < 10)? "0"+ String.valueOf(diaa):String.valueOf(diaa);
                    String mesFormato = (mesActual < 10)? "0" + String.valueOf(mesActual): String.valueOf(mesActual);
                    fechanac.setText("Fecha de Nacimiento "+diaFormato+" / "+mesFormato+" / "+año);
                    aa=año;
                    ma= Integer.parseInt(mesFormato);
                    edad.setText(calcular(anio,(mes+1),aa,ma));

                }
            }, anio, mes, dia);
            recogerFecha.show();

        }
    }

    public String calcular(int a, int m,int aa,int ma){
    int años=0;
    int meses = 0;
    if(ma<=m){
    años = a-aa;
    meses = m-ma;
    }else{
        años = a-aa-1;
        meses=12-(ma-m);
    }
    return "Edad : " + años + " Años "+" con " + meses + " Meses";
    }
}