package com.example.assignment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    // تحديث الـ Interface ليقبل الاسم المدخل
    public interface OnFragment2Listener {
        void onContinueClicked(String name);
    }

    private OnFragment2Listener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment2Listener) {
            listener = (OnFragment2Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragment2Listener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        Button btnContinue = view.findViewById(R.id.btnContinue2);
        EditText etName = view.findViewById(R.id.etName);
        EditText etEmail = view.findViewById(R.id.etEmail);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // قراءة الاسم الذي كتبه المستخدم
                String nameText = etName.getText().toString();

                if (nameText.isEmpty()) {
                    etName.setError("Please enter your name");
                    return;
                }

                if (listener != null) {
                    listener.onContinueClicked(nameText);
                }
            }
        });

        return view;
    }
}