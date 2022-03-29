package com.example.activityfirebase.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.activityfirebase.R;
import com.example.activityfirebase.databinding.FragmentHomeBinding;
import com.example.activityfirebase.process.Preferences;

public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;
    EditText usuario,password;
    Button btnCargar, btnSalvar;
    com.example.activityfirebase.process.Preferences preferences;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

            View root = inflater.inflate(R.layout.fragment_home,container,false);

            usuario = root.findViewById(R.id.txtUser);
            password = root.findViewById(R.id.txtClave);

            btnCargar = root.findViewById(R.id.btnload);
            btnSalvar= root.findViewById(R.id.btnSave);

            btnCargar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cargarInfo();
                }
            });

            btnSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveInfo();
                }
            });

            preferences = new Preferences();
            preferences.loadProferences(getContext());
            cargarInfo();
        return root;
    }

    private void saveInfo(){
        preferences.savePreferences(getContext(),usuario.getText().toString(),password.getText().toString());
        Toast.makeText(getContext(), "Datos Salvados", Toast.LENGTH_SHORT).show();
    }

    private  void cargarInfo(){
        try {
            usuario.setText(preferences.getNombre());
            password.setText(preferences.getPassword());
        }catch (Exception exception){
            exception.toString();
        }


    }

}