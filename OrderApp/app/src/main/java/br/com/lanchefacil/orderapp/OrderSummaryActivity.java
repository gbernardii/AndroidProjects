package br.com.lanchefacil.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderSummaryActivity extends AppCompatActivity {
    private TextView tvResumo;
    private Button btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        tvResumo = findViewById(R.id.tvResumo);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);

        String nome = getIntent().getStringExtra("NOME");
        String lanche = getIntent().getStringExtra("LANCHE");

        if (nome != null && lanche != null) {
            tvResumo.setText("Pedido de " + nome + "\nLanche: " + lanche);
        }

        btnNovoPedido.setOnClickListener(v -> {
            Intent intent = new Intent(OrderSummaryActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }
}