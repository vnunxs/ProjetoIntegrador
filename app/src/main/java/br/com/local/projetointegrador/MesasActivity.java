package br.com.local.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MesasActivity extends AppCompatActivity {
    GridView gridViewMesas;
    String[] mesaSelec;
    String txtNumMesa[]={
            "Mesa 1","Mesa 2","Mesa 3","Mesa 4","Mesa 5","Mesa 6","Mesa 7","Mesa 8",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mesas_layout);
        gridViewMesas = findViewById(R.id.gridMesas);

        AdaptadorMesas adapter = new AdaptadorMesas();
        gridViewMesas.setAdapter(adapter);

        gridViewMesas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ii = new Intent(MesasActivity.this, MenuActivity.class);
                //Passando valores de uma janela para outra
                mesaSelec = txtNumMesa[i].split(" ");
                ii.putExtra("sendMesa", mesaSelec[1]);
                //Toast.makeText(MesasActivity.this, mesaSelec[1], Toast.LENGTH_SHORT).show();
                finish();
                startActivity(ii);

            }
        });
    }

    public class AdaptadorMesas extends BaseAdapter{

        @Override
        public int getCount() {
            return txtNumMesa.length;
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
            TextView txtMesa;
            View view = getLayoutInflater().inflate(R.layout.modelo_mesa,null);
            txtMesa = view.findViewById(R.id.txtMesa);
            txtMesa.setText(txtNumMesa[i]);
            return view;
        }
    }

}