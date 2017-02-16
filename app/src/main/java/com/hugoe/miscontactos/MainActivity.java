package com.hugoe.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hugoe.modelo.Contactos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contactos> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contactos>();
        contactos.add(new Contactos("Hugo Herrera", "5529383959", "hugoe132@gmail.com"));
        contactos.add(new Contactos("Selene Muñoz", "5531755655", "selenemu@gmail.com"));
        contactos.add(new Contactos("Karem Luna", "5543678988", "kami@gmail.com"));
        contactos.add(new Contactos("Juan Pablo Herrera", "5543448687", "juampihermu@gmail.com"));

        ArrayList<String> nombresContactos = new ArrayList<>();
        for (Contactos contacto : contactos) {
            nombresContactos.add(contacto.getNombre());
        }
        ListView listContactos = (ListView) findViewById(R.id.lvContactos);
        listContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContactos));
        listContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,DetalleContacto.class);
                i.putExtra("nombre",contactos.get(position).getNombre());
                i.putExtra("telefono",contactos.get(position).getTelefono());
                i.putExtra("email",contactos.get(position).getEmail());
                startActivity(i);
            }
        });

    }
}
