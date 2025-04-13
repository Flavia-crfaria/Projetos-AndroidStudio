package br.com.fecapccp.comprasapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox checkArroz, checkLeite, checkCarne, checkFeijao, checkRefri;
    Button btnCalcular;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkArroz = findViewById(R.id.checkArroz);
        checkLeite = findViewById(R.id.checkLeite);
        checkCarne = findViewById(R.id.checkCarne);
        checkFeijao = findViewById(R.id.checkFeijao);
        checkRefri = findViewById(R.id.checkRefri);
        btnCalcular = findViewById(R.id.btnCalcular);
        textResultado = findViewById(R.id.textResultado);

        btnCalcular.setOnClickListener(v -> {
            double total = 0.0;

            if (checkArroz.isChecked()) total += 2.69;
            if (checkLeite.isChecked()) total += 2.70;
            if (checkCarne.isChecked()) total += 16.70;
            if (checkFeijao.isChecked()) total += 3.38;
            if (checkRefri.isChecked()) total += 3.00;

            textResultado.setText(String.format("Total da compra: R$ %.2f", total));
        });
    }
}
