package br.com.fecapccp.pizzariaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox checkCalabresa, checkMussarela, checkPortuguesa;
    RadioGroup radioGrupoTamanho, radioGrupoPagamento;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkCalabresa = findViewById(R.id.checkCalabresa);
        checkMussarela = findViewById(R.id.checkMussarela);
        checkPortuguesa = findViewById(R.id.checkPortuguesa);


        radioGrupoTamanho = findViewById(R.id.radioGrupoTamanho);
        radioGrupoPagamento = findViewById(R.id.radioGrupoPagamento);


        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnFinalizar.setOnClickListener(v -> {

            StringBuilder sabores = new StringBuilder();

            if (checkCalabresa.isChecked()) sabores.append("Calabresa, ");
            if (checkMussarela.isChecked()) sabores.append("Mussarela, ");
            if (checkPortuguesa.isChecked()) sabores.append("Portuguesa, ");


            if (sabores.length() > 0) {
                sabores.setLength(sabores.length() - 2);
            }


            int idTamanho = radioGrupoTamanho.getCheckedRadioButtonId();
            String tamanho = "";
            if (idTamanho != -1) {
                RadioButton rbTamanho = findViewById(idTamanho);
                tamanho = rbTamanho.getText().toString();
            }


            int idPagamento = radioGrupoPagamento.getCheckedRadioButtonId();
            String pagamento = "";
            if (idPagamento != -1) {
                RadioButton rbPagamento = findViewById(idPagamento);
                pagamento = rbPagamento.getText().toString();
            }


            Intent intent = new Intent(MainActivity.this, ResumoActivity.class);
            intent.putExtra("sabores", sabores.toString());
            intent.putExtra("tamanho", tamanho);
            intent.putExtra("pagamento", pagamento);
            startActivity(intent);
        });
    }
}
