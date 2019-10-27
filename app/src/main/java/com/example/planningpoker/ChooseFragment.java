package com.example.planningpoker;

        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.DividerItemDecoration;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

        import static java.sql.Types.NULL;

public class ChooseFragment extends Fragment {

    private View view;
    private Button btn_vote;
    private RecyclerView myRecyclerView;
    private ChooseAdapter myAdapter;
    private ArrayList<String> data;//= {"0", "1", "2", "3", "5", "8", "13", "20", "40", "100", "Coffee"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choose, container, false);
        data = new ArrayList<>();
        data.add("0");
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("5");
        data.add("8");
        data.add("13");
        data.add("20");
        data.add("40");
        data.add("100");
        data.add("Coffee");

        btn_vote = view.findViewById(R.id.btn_vote);
        myRecyclerView = view.findViewById(R.id.recycler_view_choose);

        int numberOfColumns = 2;


        /*btn_vote = view.findViewById(R.id.btn_vote);
        myRecyclerView = view.findViewById(R.id.recycler_view_choose);

        int numberOfColumns = 4;
        myRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
        myAdapter = new ChooseAdapter(getContext(), data);
        myAdapter.setClickListener((ChooseAdapter.ItemClickListener) getActivity());
        myRecyclerView.setAdapter(myAdapter);

        btn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "you clicked on vote", Toast.LENGTH_SHORT).show();
            }
        });*/

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        myRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        myAdapter = new ChooseAdapter(getContext(), data);
        //myAdapter.setClickListener((ChooseAdapter.ItemClickListener) getActivity());
        myRecyclerView.setAdapter(myAdapter);

        btn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //itt teszed be adatbazisba
                //myadapter.getselecteditem adja meg az indexet
                Toast.makeText(getActivity(), String.valueOf(myAdapter.getSelectedPosition()+1), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + myAdapter.getItem(position) + ", which is at cell position " + position);
    }
}
