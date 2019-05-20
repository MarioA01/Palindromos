package app.m.palindromos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtResult,txtLongitud,txtInversa,txtLetras;
    EditText txtPalabra;
    Button btnVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerificar = findViewById(R.id.btnVerificar);
        txtPalabra = findViewById(R.id.txtPalabra);
        txtResult = findViewById(R.id.txtResult);
        txtLongitud = findViewById(R.id.txtLongitud);
        txtInversa = findViewById(R.id.txtInversa);
        txtLetras = findViewById(R.id.txtLetras);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palabra = txtPalabra.getText().toString();
                String reversa = "";
                int lenght = palabra.length();
                char [] array = palabra.toCharArray();
                int maxCount = 1;
                char maxChar = array[0];
                for(int i = 0, j = 0; i < palabra.length() - 1; i = j){
                    int count = 1;
                    while (++j < palabra.length() && array[i] == array[j]) {
                        count++;
                    }
                    if (count > maxCount) {
                        maxCount = count;
                        maxChar = array[i];
                    }
                }

                 for (int i = lenght - 1; i >= 0; i--){
                     reversa = reversa + palabra.charAt(i);
                 }
                 if (palabra.equals(reversa)){
                     txtResult.setText("Si");
                     txtLongitud.setText("" + lenght);
                     txtInversa.setText(reversa);
                     txtLetras.setText(""+ maxChar);
                 }else{
                     txtResult.setText("No");
                     txtLongitud.setText("" + lenght);
                     txtInversa.setText(reversa);
                     txtLetras.setText(""+ maxChar);
                 }
            }
        });

    }
}
