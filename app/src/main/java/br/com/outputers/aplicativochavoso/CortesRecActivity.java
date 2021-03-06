package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;

public class CortesRecActivity extends AppCompatActivity {

    // Criando os fields
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<AlbumCortes> arrayList = new ArrayList<>();

    //Objet vetor do caminho das imagens não populado
    public int[] img_id = new int[]{};

    ImageButton buttonCuidados;

    String mTipoCabelo;
    String mTamanhoCabelo;
    SharedPreferences CadastroPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        CadastroPreferences = getSharedPreferences("cadastro",MODE_PRIVATE);
        SharedPreferences.Editor editor = CadastroPreferences.edit();
        editor.putBoolean("RVCortes_Rec", true);
        editor.apply();



        mTipoCabelo = CadastroPreferences.getString("tipo_cabelo","nao");
        mTamanhoCabelo = CadastroPreferences.getString("tamanho_cabelo", "nao");

        VerificarCombinacao();

        setContentView(R.layout.activity_cortes_rec);

        //Instanciando
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,1);// Quantidade por coluna
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Populando o ArrayList
        for(int id : img_id){
            arrayList.add(new AlbumCortes(id));
        }

        adapter = new RecyclerAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);


        buttonCuidados = findViewById(R.id.image_button_cuidados);
        buttonCuidados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCuidados = new Intent(CortesRecActivity.this, CuidadosActivity.class);
                startActivity(intentCuidados);
            }
        });

    }


    private void VerificarCombinacao() {


        //Verificando as combinações e populando o vetor

        if(mTipoCabelo.equals("afro") && mTamanhoCabelo.equals("curto")){

            img_id = new int[]{
                    R.drawable.af_curto_1,R.drawable.af_curto_2,
                    R.drawable.af_curto_3,R.drawable.af_curto_4,
                    R.drawable.af_curto_5
            };
        }else if(mTipoCabelo.equals("afro") && mTamanhoCabelo.equals("medio")){

            img_id = new int[]{
                    R.drawable.af_medio_1, R.drawable.af_medio_2,
                    R.drawable.af_medio_3, R.drawable.af_medio_4,
                    R.drawable.af_medio_5
            };

        } else if(mTipoCabelo.equals("afro") && mTamanhoCabelo.equals("longo")){

            img_id = new int[]{
                    R.drawable.af_longo_1, R.drawable.af_longo_2,
                    R.drawable.af_longo_3,R.drawable.af_longo_4
            };

        }else if(mTipoCabelo.equals("cacheado") && mTamanhoCabelo.equals("curto")){

            img_id = new int[]{
                    R.drawable.cach_curto_1, R.drawable.cach_curto_2,
                    R.drawable.cach_curto_3, R.drawable.cach_curto_4
            };
        }else if(mTipoCabelo.equals("cacheado") && mTamanhoCabelo.equals("medio")){
            img_id = new int[]{
                    R.drawable.cach_medio_1, R.drawable.cach_medio_2,
                    R.drawable.cach_medio_3, R.drawable.cach_medio_4
            };
        }else if(mTipoCabelo.equals("cacheado") && mTamanhoCabelo.equals("longo")){
            img_id = new int[]{
                    R.drawable.cach_longo_1, R.drawable.cach_longo_2,
                    R.drawable.cach_longo_3,R.drawable.cach_longo_4
            };
        }else if(mTipoCabelo.equals("liso") && mTamanhoCabelo.equals("curto")){
            img_id = new int[]{
                    R.drawable.liso_curto_1, R.drawable.liso_curto_2,
                    R.drawable.liso_curto_3, R.drawable.liso_curto_4,
                    R.drawable.liso_curto_5
            };
        }else if(mTipoCabelo.equals("liso") && mTamanhoCabelo.equals("medio")){
            img_id = new int[]{
                    R.drawable.liso_medio_1, R.drawable.liso_medio_2,
                    R.drawable.liso_medio_3, R.drawable.liso_medio_4,
                    R.drawable.liso_medio_5
            };
        }else if(mTipoCabelo.equals("liso") && mTamanhoCabelo.equals("longo")){
            img_id = new int[]{
                    R.drawable.liso_longo_1, R.drawable.liso_longo_2,
                    R.drawable.liso_longo_3, R.drawable.liso_longo_4
            };
        }else if(mTipoCabelo.equals("ondulado") && mTamanhoCabelo.equals("curto")){
            img_id = new int[]{
                    R.drawable.ond_curto_1, R.drawable.ond_curto_2,
                    R.drawable.ond_curto_3, R.drawable.ond_curto_4
            };
        }else if(mTipoCabelo.equals("ondulado") && mTamanhoCabelo.equals("medio")){
            img_id = new int[]{
                    R.drawable.ond_medio_1, R.drawable.ond_medio_2,
                    R.drawable.ond_medio_3, R.drawable.ond_medio_4
            };
        }else if(mTipoCabelo.equals("ondulado") && mTamanhoCabelo.equals("longo")){
            img_id = new int[]{
                    R.drawable.ond_longo_1, R.drawable.ond_longo_2,
                    R.drawable.ond_longo_3, R.drawable.ond_longo_4
            };
        }




    }

}