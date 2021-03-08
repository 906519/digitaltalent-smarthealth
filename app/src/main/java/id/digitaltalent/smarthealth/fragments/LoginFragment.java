package id.digitaltalent.smarthealth.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;

import id.digitaltalent.smarthealth.R;
import id.digitaltalent.smarthealth.activities.LoginActivity;
import id.digitaltalent.smarthealth.activities.MainActivity;


public class LoginFragment extends Fragment {

    ScrollView scrollView;
    EditText vPhone;
    EditText vPassword;
    private String phone, password;
    Button vLogin, vRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        vPhone = (EditText) view.findViewById(R.id.input_phone);
        vPassword = (EditText) view.findViewById(R.id.input_password);
        scrollView = (ScrollView) view.findViewById(R.id.scroll_view);
        vLogin = (Button) view.findViewById(R.id.btn_login);
        vRegister = (Button) view.findViewById(R.id.btn_register);

        vLogin.setOnClickListener(view1 -> {
            ((LoginActivity) getActivity()).startActivity(new Intent(getActivity(), MainActivity.class));
        });

        vRegister.setOnClickListener(view1 -> {
            ((LoginActivity) getActivity()).loadFragment(getActivity(), new RegisterFragment());
        });

        vPhone.setOnFocusChangeListener((view1, hasFocus) -> {
            scrollUp(hasFocus);
        });

        vPassword.setOnFocusChangeListener((view1, hasFocus) -> {
            scrollUp(hasFocus);
        });

        vPhone.setOnClickListener(view1 -> {
            scrollUp(true);
        });

        vPassword.setOnClickListener(view1 -> {
            scrollUp(true);
        });
        return view;
    }

    private void scrollUp(boolean hasFocus){
        if (hasFocus) {
            scrollView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    View lastChild = scrollView.getChildAt(scrollView.getChildCount() - 1);
                    int bottom = lastChild.getBottom() + scrollView.getPaddingBottom();
                    int sy = scrollView.getScrollY();
                    int sh = scrollView.getHeight();
                    int delta = bottom - (sy + sh);
                    scrollView.smoothScrollBy(0, delta);
                }
            }, 200);
        }
    }

    private void getData() {
        phone = vPhone.getText().toString().trim();
        password = vPassword.getText().toString().trim();
    }
}
