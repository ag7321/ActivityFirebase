package com.example.activityfirebase.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.activityfirebase.R;
import com.example.activityfirebase.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    TextView texto;
    Button btnConsulta;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

            View root = inflater.inflate(R.layout.fragment_gallery,container,false);

            texto = root.findViewById(R.id.text_gallery);
            btnConsulta = root.findViewById(R.id.button);


            btnConsulta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    texto.setText("Hola");
                }
            });


        return root;
    }


}