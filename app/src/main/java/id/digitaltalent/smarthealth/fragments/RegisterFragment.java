package id.digitaltalent.smarthealth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import id.digitaltalent.smarthealth.R;
import id.digitaltalent.smarthealth.activities.LoginActivity;


public class RegisterFragment extends Fragment {

    EditText vPhone;
    EditText vPassword;
    TextView vLogin;
    Button vRegister;

    private String phone, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        vPhone = (EditText) view.findViewById(R.id.input_phone);
        vPassword = (EditText) view.findViewById(R.id.input_password);
        vLogin = (TextView) view.findViewById(R.id.btn_login);
        vRegister = (Button) view.findViewById(R.id.btn_register);

        vLogin.setOnClickListener(view1 -> {
            ((LoginActivity) getActivity()).loadFragment(getActivity(), new LoginFragment());
        });

        vRegister.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Register berhasil", Toast.LENGTH_LONG).show();
            ((LoginActivity) getActivity()).loadFragment(getActivity(), new LoginFragment());
        });
        return view;
    }

    private void getData() {
        phone = vPhone.getText().toString().trim();
        password = vPassword.getText().toString().trim();
    }
}
