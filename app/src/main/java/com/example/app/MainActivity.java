package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.app.adapter.UsuarioAdapter;
import com.example.app.model.Usuario;
import com.example.app.network.ApiClient;
import com.example.app.network.ApiUsuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Usuario> usuarios;
    private RecyclerView recyclerView;
    private UsuarioAdapter usuarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        showUsuarios();


    }

    public void showUsuarios(){
        Call<List<Usuario>> call = ApiClient.getClient().create(ApiUsuario.class).getUsuarios();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if(response.isSuccessful()){
                    usuarios = response.body();
                    usuarioAdapter = new UsuarioAdapter(usuarios,getApplicationContext());
                    recyclerView.setAdapter(usuarioAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error al consumir API", Toast.LENGTH_SHORT).show();

            }
        });
    }

}