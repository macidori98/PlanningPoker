package com.example.planningpoker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MenuActivity extends AppCompatActivity {

    private Button btn_choose, btn_list;

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

        if (getSupportFragmentManager().findFragmentByTag("CHOOSE_FRAG") != null) {
            //Toast.makeText(this, "back", Toast.LENGTH_LONG).show();
            getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag("CHOOSE_FRAG")).commit();
        } else if (getSupportFragmentManager().findFragmentByTag("LIST_FRAG") != null){
            getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag("LIST_FRAG")).commit();
        }else
            {
            super.onBackPressed();
        }
    }


}
