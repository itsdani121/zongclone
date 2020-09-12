package com.example.zongclone;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class mainFragment extends Fragment {
    TextView textView, textView1, textView2;
    CardView btn_wifi, btn_calls, btn_sms;

    private NavController controller;

    public mainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return
                inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findview(view);
        changeXml();
        clickListener();

    }

    private void intentData(Class target) {
        Intent intent = new Intent(getContext(), target);
        startActivity(intent);
    }

    void changeXml() {
        textView2.setText(Html.fromHtml("<span style=color:green>680</span> <span style=color:black><small>Msg</small></span> "));
        textView.setText(Html.fromHtml("<span style=color:green> 17000</span> <span style=color:black><small>MB</small></span>"));
        textView1.setText(Html.fromHtml("<span style=color:green> 750 </span> <span style=color:black><small>Min</small></span>"));
    }

    private void findview(View view) {
        btn_wifi = view.findViewById(R.id.wifi_cv);
        btn_calls = view.findViewById(R.id.mns_cv);
        btn_sms = view.findViewById(R.id.sms_cv);
        textView = view.findViewById(R.id.card_number);
        textView1 = view.findViewById(R.id.card_numberx);
        textView2 = view.findViewById(R.id.card_numbersx);

        controller = Navigation.findNavController(requireActivity(), R.id.host_fragment);
    }

    private void clickListener() {
//        btn_wifi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont, new usageFragment()).addToBackStack("").commit();
//            }
//        });
        btn_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentData(usageFragment.class);
            }
        });
        btn_calls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentData(usageFragment.class);
            }
        });

        btn_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.navigate(R.id.action_mainFragment_to_loanFragment);
            }
        });
    }
}


