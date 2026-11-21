package com.example.assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    private static final String ARG_NAME = "user_name";
    private String userName;

    public static Fragment3 newInstance(String name) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userName = getArguments().getString(ARG_NAME);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        TextView tvWelcomeName = view.findViewById(R.id.tvWelcomeName);
        CheckBox checkBoxAgree = view.findViewById(R.id.checkBoxAgree);
        Button btnFinish = view.findViewById(R.id.btnFinish);

        if (userName != null) {
            tvWelcomeName.setText("Welcome, " + userName);
        }

        checkBoxAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnFinish.setEnabled(true);
                    btnFinish.setText("Finish");
                } else {
                    btnFinish.setEnabled(false);
                    btnFinish.setText("Continue");
                }
            }
        });

        // هنا أضفنا الكود الجديد عند الضغط على زر Finish
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "تم التسجيل بنجاح، أهلاً بك يا " + userName, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}