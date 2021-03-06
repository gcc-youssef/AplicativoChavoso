package br.com.outputers.aplicativochavoso;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;


/**
 * Created by Lucas Dutra on 11/09/2017.
 */

public class Tab3TamanhoC extends Fragment {

    String TamanhoCabelo = "null";

    ImageButton btnTamanhoCurto;
    ImageButton btnTamanhoMedio;
    ImageButton btnTamandoLongo;

    SharedPreferences CadastroPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab3, container, false);

        //Instanciando os ImageButton
        btnTamanhoCurto = rootView.findViewById(R.id.imgbtn_tamanho_curto);
        btnTamanhoMedio = rootView.findViewById(R.id.imgbtn_tamanho_medio);
        btnTamandoLongo = rootView.findViewById(R.id.imgbtn_tamanho_longo);

        //Usando o Glide para popular as imagens dos ImageButton
        Glide.with(rootView).load(R.drawable.tamanho_curto).into(btnTamanhoCurto);
        Glide.with(rootView).load(R.drawable.tamanho_medio).into(btnTamanhoMedio);
        Glide.with(rootView).load(R.drawable.tamanho_longo).into(btnTamandoLongo);

        final SharedPreferences CadastroPreferences = this.getActivity().getSharedPreferences("cadastro", Context.MODE_PRIVATE);

        btnTamanhoCurto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "curto";
                GuardarTamanhoCabelo();
                IntentCortesRec(rootView);
            }
        });

        btnTamanhoMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "medio";
                GuardarTamanhoCabelo();
                IntentCortesRec(rootView);
            }
        });

        btnTamandoLongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "longo";
                GuardarTamanhoCabelo();
                IntentCortesRec(rootView);
            }
        });

        return rootView;
    }

    public void GuardarTamanhoCabelo(){

        CadastroPreferences = this.getActivity().getSharedPreferences("cadastro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = CadastroPreferences.edit();
        editor.putString("tamanho_cabelo", TamanhoCabelo);
        editor.apply();

        Log.e("Guardar Tipo Cabelo", CadastroPreferences.getString("tamanho_cabelo","nao"));

    }


    public void IntentCortesRec(View rootView) {

        CadastroPreferences = this.getActivity().getSharedPreferences("cadastro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = CadastroPreferences.edit();

        String mTipoRosto = CadastroPreferences.getString("tipo_rosto", "nao");
        String mTipoCabelo = CadastroPreferences.getString("tipo_cabelo", "nao");
        String mTamanhoCabelo = CadastroPreferences.getString("tamanho_cabelo", "nao");

        Boolean cadastrou = CadastroPreferences.getBoolean("cadastrou", false);

        //Tratando usuário retardado
        if (mTipoRosto.equals("nao") || mTipoCabelo.equals("nao") || mTamanhoCabelo.equals("nao")) {

            Toast.makeText(rootView.getContext(), "Preencha todos os dados antes de prosseguir", Toast.LENGTH_SHORT).show();

        } else if(cadastrou){

            Toast.makeText(rootView.getContext(), "Seus dados foram atualizados", Toast.LENGTH_SHORT).show();
            getActivity().finish();

        }else{

            Intent intentSegundaTela = new Intent(getActivity(), TelaInicial2vez.class);

            editor.putBoolean("cadastrou", true);
            editor.apply();

            Toast.makeText(rootView.getContext(), "Seus dados foram salvos", Toast.LENGTH_SHORT).show();

            startActivity(intentSegundaTela);
            getActivity().finish();
        }
    }
}
