package br.com.temdetudo.clientregistrationapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnIniciarCadastro;
    private TextView tvDominio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarCadastro = findViewById(R.id.btnIniciarCadastro);
        tvDominio = findViewById(R.id.tvDominio);

        btnIniciarCadastro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        tvDominio.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.temdetudo.com.br"));
            startActivity(browserIntent);
        });
    }
}