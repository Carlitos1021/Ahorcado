package com.carlos.ahorcado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText capturar;
    LinearLayout ly_contenedor;
    Button obtener;
    Button comparar;
    String palabra;
   //private final String palabra = "ajajhahhah";
    private EditText controles[];

    int contador=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ly_contenedor = (LinearLayout)findViewById(R.id.ly_contenedor);

        capturar = (EditText)findViewById(R.id.Ingresar);
        comparar = (Button)findViewById(R.id.Verificar);

        comparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(getAllText().equals(palabra)){

                        Toast.makeText(getApplicationContext(),"Es correcto",Toast.LENGTH_SHORT).show();
                    }else {

                        contador--;
                        Toast.makeText(getApplicationContext(),"Es incorrecto",Toast.LENGTH_SHORT).show();
                        if (contador==0){
                            limpiar();
                            Intent intent = new Intent(MainActivity.this,FinalActivity.class);
                            startActivity(intent);
                        }
                    }
            }
        });

    }

    private String getAllText(){

        String respuesta="";
        for (int i = 0; i<controles.length; i++){
            respuesta = respuesta + controles[i].getText().toString();
           limpiar();
        }

        return respuesta;
    }

    public void capturar(View view){

        palabra = capturar.getText().toString();

        controles = new EditText[palabra.length()];

        for(int fila=0; fila<controles.length; fila++){

            controles[fila] = new EditText(getApplicationContext());
            controles[fila].setHint(fila+" ");
            ly_contenedor.addView(controles[fila]);
        }

        limpiar();
    }


    private boolean notBlack(){

        boolean valor=true;
        for (int i = 0; i<controles.length; i++){
            if(controles[i].getText().toString().isEmpty()){
                valor = false;
                break;
            }

            limpiar();
        }

        return valor;
    }

  public void limpiar(){

        capturar.setText("");

  }

}
