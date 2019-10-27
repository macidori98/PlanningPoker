package com.example.planningpoker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                fragmentTransaction.replace(R.id.activityMain, new ChooseFragment(), ChooseFragment.class.getSimpleName());
                fragmentTransaction.commitAllowingStateLoss();


            }
        });


        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new ListFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.recycler_view_list, fragment);
        fragmentTransaction.commit();
    }
}
/*
* public static void loadBasicFoodsDetailsFragment(FragmentActivity fragmentActivity, int index) {
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment = fragmentActivity.getSupportFragmentManager().findFragmentByTag("BasicFoodsDetailsFragment");
        if (fragment == null) {
            fragment = new BasicFoodDetailsFragment();
        }
        fragment.setArguments(bundle);
        loadFragment(fragment, fragmentActivity);
    }


    private static void loadFragment(Fragment fragment, FragmentActivity fragmentActivity) {
        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_activity_content_frame_layout, fragment, fragment.getClass().getSimpleName());
        ft.commit();
    }
* */