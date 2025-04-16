package br.com.gustavobernardi.shoppingappwithcheckbox;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbCoca;
    private TextView tvTotal;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculando os componentes do layout
        cbArroz = findViewById(R.id.cbArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbCoca = findViewById(R.id.cbCoca);
        tvTotal = findViewById(R.id.tvTotal);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Ação do botão para calcular o total
        btnCalcular.setOnClickListener(v -> calcularTotal());
    }

    private void calcularTotal() {
        double total = 0.0;

        // Verificando quais checkboxes estão marcados e somando os valores
        if (cbArroz.isChecked()) total += 2.69;
        if (cbLeite.isChecked()) total += 2.70;
        if (cbCarne.isChecked()) total += 16.70;
        if (cbFeijao.isChecked()) total += 3.38;
        if (cbCoca.isChecked()) total += 3.00;

        // Exibindo o total formatado
        tvTotal.setText(String.format("Total: R$ %.2f", total));
    }
}