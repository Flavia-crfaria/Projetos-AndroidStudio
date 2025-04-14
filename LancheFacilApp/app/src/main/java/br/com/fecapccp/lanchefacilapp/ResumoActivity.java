package br.com.fecapccp.lanchefacilapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoActivity extends AppCompatActivity {

    TextView txtResumo;
    Button btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtResumo = findViewById(R.id.txtResumo);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);


        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String lanche = intent.getStringExtra("lanche");


        txtResumo.setText("Pedido de " + nome + " :\n" + lanche);


        btnNovoPedido.setOnClickListener(v -> {
            Intent voltar = new Intent(ResumoActivity.this, MainActivity.class);
            voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(voltar);
        });
    }
}
