package br.com.fecapccp.lanchefacilapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnFazerPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFazerPedido = findViewById(R.id.btnFazerPedido);

        btnFazerPedido.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PedidoActivity.class);
            startActivity(intent);
        });
    }
}
