package br.com.outputers.aplicativochavoso;

/**
 * Created by Lucas Dutra on 11/09/2017.
 */
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Tab1TRosto extends Fragment  {

    ImageButton btnRostoQuadrado;
    ImageButton btnRostoRedondo;
    ImageButton btnRostoOval;
    ImageButton btnRostoTriangular;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab1, container, false);

        //instanciando os btn, sempre usando rootView.
        btnRostoQuadrado = rootView.findViewById(R.id.imgbtn_rosto_quadrado);
        btnRostoRedondo = rootView.findViewById(R.id.imgbtn_rosto_redondo);
        btnRostoOval = rootView.findViewById(R.id.imgbtn_rosto_oval);
        btnRostoTriangular = rootView.findViewById(R.id.imgbtn_rosto_triangular);


        btnRostoQuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(rootView.getContext(), "quadrado", Toast.LENGTH_SHORT).show();
            }
        });

        btnRostoRedondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(rootView.getContext(), "redondo", Toast.LENGTH_SHORT).show();
            }
        });

        btnRostoOval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(rootView.getContext(), "oval", Toast.LENGTH_SHORT).show();
            }
        });

        btnRostoTriangular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(rootView.getContext(), "triangular", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }




}
