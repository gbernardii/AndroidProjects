package br.com.lanchefacil.orderapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnIniciarPedido;
    private TextView tvDominio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarPedido = findViewById(R.id.btnIniciarPedido);
        tvDominio = findViewById(R.id.tvDominio);

        btnIniciarPedido.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, OrderFormActivity.class);
            startActivity(intent);
        });

        tvDominio.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lanchefacil.com.br"));
            startActivity(browserIntent);
        });
    }
}