package br.com.fecapccp.temdetudoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    EditText editNome;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.editNome);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(view -> {
            String nome = editNome.getText().toString().trim();

            if (nome.isEmpty()) {
                Toast.makeText(this, "Digite um nome!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(CadastroActivity.this, ConfirmacaoActivity.class);
                intent.putExtra("nome_cliente", nome);
                startActivity(intent);
            }
        });
    }
}
