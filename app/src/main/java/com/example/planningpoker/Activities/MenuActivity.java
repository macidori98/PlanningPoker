package com.example.planningpoker.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.planningpoker.Adapters_and_fragments.ChooseFragment;
import com.example.planningpoker.Adapters_and_fragments.ListFragment;
import com.example.planningpoker.R;

public class MenuActivity extends AppCompatActivity {

    public static Button btn_choose, btn_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_choose = findViewById(R.id.btn_choose);
        btn_list = findViewById(R.id.btn_list);

        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.activityMain, new ChooseFragment(), ChooseFragment.TAG);
                fragmentTransaction.commit();
            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.activityMain, new ListFragment(), ListFragment.TAG);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        btn_list.setVisibility(View.VISIBLE);
        btn_choose.setVisibility(View.VISIBLE);
        if (getSupportFragmentManager().findFragmentByTag(ListFragment.TAG) != null){
            getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(ListFragment.TAG)).commit();
        } else
        if (getSupportFragmentManager().findFragmentByTag(ChooseFragment.TAG) != null) {
            getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(ChooseFragment.TAG)).commit();
        } else
            {
            super.onBackPressed();
        }
    }


}
