package br.com.fecapccp.temdetudoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacaoActivity extends AppCompatActivity {

    TextView txtMensagem;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        txtMensagem = findViewById(R.id.txtMensagem);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Recebe o nome vindo da tela anterior
        Intent intent = getIntent();
        String nomeCliente = intent.getStringExtra("nome_cliente");

        // Exibe mensagem personalizada
        txtMensagem.setText("Bem-vindo, " + nomeCliente + "!");

        // Botão para voltar à tela inicial
        btnVoltar.setOnClickListener(v -> {
            Intent voltar = new Intent(ConfirmacaoActivity.this, MainActivity.class);
            // limpa o histórico para não voltar com "voltar"
            voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(voltar);
        });
    }
}
