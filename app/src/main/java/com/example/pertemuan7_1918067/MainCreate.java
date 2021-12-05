package com.example.pertemuan7_1918067;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Eusername, Ebalaikota;
    private String Susername, Sbalaikota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Eusername = (EditText) findViewById(R.id.create_Username);
        Ebalaikota = (EditText) findViewById(R.id.create_Balai);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Susername = String.valueOf(Eusername.getText());
                Sbalaikota = String.valueOf(Ebalaikota.getText());
                if (Susername.equals("")){
                    Eusername.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi username geme",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sbalaikota.equals("")) {
                    Ebalaikota.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Balai kota",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Eusername.setText("");
                    Ebalaikota.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new Clashofclans(null, Susername,
                            Sbalaikota));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
