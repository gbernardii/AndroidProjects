package br.com.lanchefacil.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class OrderFormActivity extends AppCompatActivity {
    private TextInputEditText etNome;
    private RadioGroup rgLanche;
    private Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);

        etNome = findViewById(R.id.etNome);
        rgLanche = findViewById(R.id.rgLanche);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(v -> {
            String nome = etNome.getText().toString().trim();
            if (nome.isEmpty()) {
                etNome.setError("Por favor, insira seu nome");
                return;
            }

            String lanche = "";
            int selectedId = rgLanche.getCheckedRadioButtonId();
            if (selectedId == R.id.rbHamburguer) {
                lanche = "Hambúrguer";
            } else if (selectedId == R.id.rbWrap) {
                lanche = "Wrap";
            } else if (selectedId == R.id.rbSanduiche) {
                lanche = "Sanduíche";
            }

            Intent intent = new Intent(OrderFormActivity.this, OrderSummaryActivity.class);
            intent.putExtra("NOME", nome);
            intent.putExtra("LANCHE", lanche);
            startActivity(intent);
        });
    }
}