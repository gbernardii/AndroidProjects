package br.com.gustavobernardi.salaryadjustmentapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etSalario;
    private RadioGroup rgPercentual;
    private Button btnCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculando os componentes do layout
        etSalario = findViewById(R.id.etSalario);
        rgPercentual = findViewById(R.id.rgPercentual);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        // Ação do botão para calcular o novo salário
        btnCalcular.setOnClickListener(v -> calcularNovoSalario());
    }

    private void calcularNovoSalario() {
        // Verificar se o campo de salário está vazio
        String salarioStr = etSalario.getText().toString();
        if (salarioStr.isEmpty()) {
            tvResultado.setText("Por favor, insira o salário.");
            return;
        }

        // Converter o salário para double
        double salario;
        try {
            salario = Double.parseDouble(salarioStr);
        } catch (NumberFormatException e) {
            tvResultado.setText("Salário inválido. Use números.");
            return;
        }

        // Determinar o percentual de aumento
        double percentual = 0.0;
        int selectedId = rgPercentual.getCheckedRadioButtonId();
        if (selectedId == R.id.rb40) {
            percentual = 0.40;
        } else if (selectedId == R.id.rb45) {
            percentual = 0.45;
        } else if (selectedId == R.id.rb50) {
            percentual = 0.50;
        }

        // Calcular o novo salário
        double aumento = salario * percentual;
        double novoSalario = salario + aumento;

        // Exibir o resultado formatado
        tvResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
    }
}