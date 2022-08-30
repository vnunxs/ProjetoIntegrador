package br.com.local.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MenuPrincipalActivity extends AppCompatActivity {

    Button btnDiminuirQuantidade, btnAumentarQuantidade;
    EditText edtQuantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal_layout);
        btnDiminuirQuantidade = findViewById(R.id.btnDiminuirQuantidade);
        btnAumentarQuantidade = findViewById(R.id.btnAumentarQuantidade);

        btnAumentarQuantidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtQuantidade = findViewById(R.id.edtQuantidade);
                Integer quant = Integer.parseInt(String.valueOf(edtQuantidade.getText()));
                edtQuantidade.setText(String.valueOf(quant + 1));
            }
        });
        btnDiminuirQuantidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtQuantidade = findViewById(R.id.edtQuantidade);
                Integer quant = Integer.parseInt(String.valueOf(edtQuantidade.getText()));
                if (quant > 0) {
                    edtQuantidade.setText(String.valueOf(quant - 1));
                }
            }
        });
    }
}