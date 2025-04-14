package br.com.fecapccp.lanchefacilapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PedidoActivity extends AppCompatActivity {

    EditText editNome;
    RadioGroup radioGroupLanches;
    Button btnConfirmarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        editNome = findViewById(R.id.editNome);
        radioGroupLanches = findViewById(R.id.radioGroupLanches);
        btnConfirmarPedido = findViewById(R.id.btnConfirmarPedido);

        btnConfirmarPedido.setOnClickListener(view -> {
            String nome = editNome.getText().toString().trim();

            int selectedId = radioGroupLanches.getCheckedRadioButtonId();

            if (nome.isEmpty() || selectedId == -1) {
                Toast.makeText(this, "Preencha seu nome e selecione um lanche", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton radioSelecionado = findViewById(selectedId);
                String lancheEscolhido = radioSelecionado.getText().toString();

                Intent intent = new Intent(PedidoActivity.this, ResumoActivity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("lanche", lancheEscolhido);
                startActivity(intent);
            }
        });
    }
}
