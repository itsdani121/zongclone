package com.example.zongclone;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class usageFragment extends Fragment {


    TextView textView;
    TextView textView1;
    TextView textView2;
    ProgressBar progressBar;
    ProgressBar progressBar2;
    TextView textView3;
    TextView textView4;
    TextView textView5,textView6;

    public usageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_usage, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findView(view);
        formate();

    }


    private void formate() {
        textView4.setText(String.valueOf(progressBar.getProgress() + "% Used"));
        textView5.setText(String.valueOf(progressBar2.getProgress() + "% Used"));
        textView3.setText(Html.fromHtml("<span style=color:black>MBB Monthly 100gb(4am-4pm)</span><br><span><small>16613/102400MBs</small></span>"));
        textView2.setText(Html.fromHtml("<span style=color:black><b>MBB Monthly 200 GB</b></span><br><span ><small>Expire on 30-Sep-2020</small></span>"));
        textView1.setText(Html.fromHtml("<span style=color:red>3250PKR</span><br><span style=color:black><small>incl Tax</small></span>"));
        textView.setText(Html.fromHtml("<span style=color:green>18005</span><span style=color:black><small>Mb</small></span>"));
        textView6.setText(Html.fromHtml("<span style=color:black>MBB Monthly 100gb(No Time Based)</span><br><span><small>19413/102400MBs</small></span>"));

    }

    public void findView(View view) {
        textView = view.findViewById(R.id.usage_number);
        textView1 = view.findViewById(R.id.price_tv);
        textView2 = view.findViewById(R.id.plan_tv);
        progressBar = view.findViewById(R.id.timeOffer_progress);
        progressBar2 = view.findViewById(R.id.noTime_progress);
        textView3 = view.findViewById(R.id.timeOffer_tv);
        textView4 = view.findViewById(R.id.value);
        textView5 = view.findViewById(R.id.value2);
        textView6=view.findViewById(R.id.noTime_tv);
    }

}