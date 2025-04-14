package br.com.fecapccp.pizzariaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoActivity extends AppCompatActivity {

    TextView txtResumoPedido;
    Button btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtResumoPedido = findViewById(R.id.txtResumoPedido);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);


        Intent intent = getIntent();
        String sabores = intent.getStringExtra("sabores");
        String tamanho = intent.getStringExtra("tamanho");
        String pagamento = intent.getStringExtra("pagamento");


        String resumo = "🍕 Sabores: " + sabores +
                "\n📏 Tamanho: " + tamanho +
                "\n💳 Pagamento: " + pagamento;

        txtResumoPedido.setText(resumo);

        btnNovoPedido.setOnClickListener(v -> {
            Intent voltar = new Intent(ResumoActivity.this, MainActivity.class);
            voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(voltar);
        });
    }
}
