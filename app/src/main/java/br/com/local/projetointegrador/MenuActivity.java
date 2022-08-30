package br.com.local.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {
    GridView gridView;
    ImageView IconSettingsMenu;
    Button botaoMesa;

    //Salvando o número da mesa nessa janela

    Intent getMesa = getIntent();
    String nMesa = getMesa.getStringExtra("sendMesa");


    int imgCardapio[] = {
            R.drawable.hamburguermodel, R.drawable.pizzamodel, R.drawable.batatamodel,
            R.drawable.hamburguermodel, R.drawable.pizzamodel, R.drawable.batatamodel,
            R.drawable.hamburguermodel, R.drawable.pizzamodel, R.drawable.batatamodel,
    };
    String nomeProduto[] = {"Zinguer Burguer", "Pizza Peperone", "Batata Média",
            "Zinguer Burguer", "Pizza Peperone", "Batata Média",
            "Zinguer Burguer", "Pizza Peperone", "Batata Média"};

    String precoProduto[] = {"R$ 40,00", "R$ 35,00", "R$ 15,00", "R$ 40,00", "R$ 35,00", "R$ 15,00",
            "R$ 40,00", "R$ 35,00", "R$ 15,00"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        IconSettingsMenu = findViewById(R.id.IconSettingsMenu);
        botaoMesa = findViewById(R.id.btnTesteMesa);
        gridView = findViewById(R.id.GriedViewMenu);
        botaoMesa.setText("Mesa Selecionada: "+nMesa);
        botaoMesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MesasActivity.class);
                startActivity(intent);

            }
        });
        AdaptadorCard adapter = new AdaptadorCard();

        gridView.setAdapter(adapter);

        IconSettingsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            }
        });


    }

    public class AdaptadorCard extends BaseAdapter {
        @Override
        public int getCount() {
            return imgCardapio.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View v, ViewGroup viewGroup) {
            TextView txtNome, txtPreco;
            ImageView imgCardapioView;


            View view = getLayoutInflater().inflate(R.layout.modelo_cardapio, null);

            txtNome = view.findViewById(R.id.txtModelCardapio);
            txtPreco = view.findViewById(R.id.txtModelValorCardapio);
            imgCardapioView = view.findViewById(R.id.ImgModelCardapio);

            txtNome.setText(nomeProduto[i]);
            txtPreco.setText(precoProduto[i]);

            imgCardapioView.setImageResource(imgCardapio[i]);


            return view;
        }
    }
}