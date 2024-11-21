package ec.edu.monster.ws_convuni_soapjava_climov.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ec.edu.monster.ws_convuni_soapjava_climov.R;

import ec.edu.monster.ws_convuni_soapjava_climov.controlador.ConvUniControlador;

public class MainActivity extends AppCompatActivity {

    private ConvUniControlador controlador;
    private TextView lblIn,lblOut;
    private EditText txtIn,txtOut;
    private Button btnTransformar, btnCambiar,btnSalir;

    private boolean libras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        libras = false;
        controlador = new ConvUniControlador();
        lblIn = findViewById(R.id.lblIn);
        lblOut = findViewById(R.id.lblOut);
        txtIn = findViewById(R.id.txtIn);
        txtOut = findViewById(R.id.txtOut);
        btnCambiar = findViewById(R.id.btnCambiar);
        btnTransformar = findViewById(R.id.btnTransformar);
        btnSalir = findViewById(R.id.btnSalir);

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiar();
            }
        });

        btnTransformar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operar();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void cambiar(){
        if(!libras){
            libras = true;
            lblIn.setText("Libras (lb)");
            lblOut.setText("Kilogramos (kg)");
        }else{
            libras = false;
            lblIn.setText("Kilogramos (kg)");
            lblOut.setText("Libras (lb)");
        }
        txtOut.setText("");
        txtIn.setText("");
    }

    private void operar(){
        String entrada = txtIn.getText().toString();
        int color = ContextCompat.getColor(this,
                (esModoOscuro() ? R.color.white : R.color.black));
        if(entrada.equals("")){
            txtIn.setText("");
            txtOut.setText("");
        }else{
            new Thread(new Runnable() {
                String salida = "";

                @Override
                public void run() {
                    if(!libras){
                        salida = controlador.convertKGLB(entrada);
                    }else{
                        salida = controlador.convertLBKG(entrada);
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(salida.equals("error")){
                                txtOut.setTextColor(Color.RED);
                                txtOut.setText("Error. El servicio no está disponible.");
                            }else{

                                txtOut.setTextColor(color);
                                txtOut.setText(salida);
                            }
                        }
                    });

                }
            }).start();
        }
    }

    private boolean esModoOscuro() {
        int modo = getResources().getConfiguration().uiMode &
                Configuration.UI_MODE_NIGHT_MASK;
        return modo == Configuration.UI_MODE_NIGHT_YES;
    }
}