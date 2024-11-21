package ec.edu.monster.ws_convuni_soapjava_climov.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ec.edu.monster.ws_convuni_soapjava_climov.R;
import ec.edu.monster.ws_convuni_soapjava_climov.controlador.LoginControlador;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUs, txtPass;
    private Button btnLogin;
    private TextView lblError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUs = findViewById(R.id.txtUs);
        txtPass = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogIn);
        lblError = findViewById(R.id.lblError);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();
            }
        });
    }

    private void logIn(){
        LoginControlador controlador = new LoginControlador();
        String usuario = txtUs.getText().toString(), clave = txtPass.getText().toString();
        boolean pass = controlador.verificar(usuario,clave);
        if(pass){
            Intent inten = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(inten);
        }
        else{
            lblError.setVisibility(View.VISIBLE);
        }
    }
}