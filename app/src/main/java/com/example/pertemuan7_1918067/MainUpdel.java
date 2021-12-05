package com.example.pertemuan7_1918067;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Susername, Sbalaikota;
    private EditText Eusername, Ebalaikota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Susername = i.getStringExtra("Inama");
        Sbalaikota = i.getStringExtra("Ikelas");
        Eusername = (EditText) findViewById(R.id.updel_username);
        Ebalaikota = (EditText) findViewById(R.id.updel_balai);
        Eusername.setText(Susername);
        Ebalaikota.setText(Sbalaikota);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Susername = String.valueOf(Eusername.getText());
                Sbalaikota = String.valueOf(Ebalaikota.getText());
                if (Susername.equals("")){
                    Eusername.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sbalaikota.equals("")){
                    Ebalaikota.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi kelas",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMahasiswa(new Clashofclans(Sid, Susername,
                            Sbalaikota));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMahasiswa(new Clashofclans(Sid, Susername,
                        Sbalaikota));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

