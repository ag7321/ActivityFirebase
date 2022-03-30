package com.example.activityfirebase.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.activityfirebase.Models.ModelCounter;
import com.example.activityfirebase.R;
import com.example.activityfirebase.databinding.FragmentSlideshowBinding;

import java.util.Observable;
import java.util.Observer;

public class SlideshowFragment extends Fragment  implements Observer,View.OnClickListener{

    private ModelCounter contador;
    private Button btn1,btn2,btn3,btn4;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_slideshow,container,false);
        contador = new ModelCounter();

        btn1 = root.findViewById(R.id.btn1);
        btn2 = root.findViewById(R.id.btn2);
        btn3 = root.findViewById(R.id.btn3);
        btn4 = root.findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);


        return root;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                contador.setValForIndex(0);
                break;
            case R.id.btn2:
                contador.setValForIndex(1);
                break;
            case R.id.btn3:
                contador.setValForIndex(2);
                break;
            case R.id.btn4:
                contador.setValForIndex(3);
                break;
        }
    }
    
    @Override
    public void update(Observable observable, Object o) {
        btn1.setText("Contados" + contador.obtenerValForIndex(0));
        btn2.setText("Contados" + contador.obtenerValForIndex(1));
        btn3.setText("Contados" + contador.obtenerValForIndex(2));
        btn4.setText("Contados" + contador.obtenerValForIndex(3));
    }
}