package com.example.planningpoker.Adapters_and_fragments;

        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.planningpoker.Activities.LoginActivity;
        import com.example.planningpoker.Activities.MenuActivity;
        import com.example.planningpoker.Database.DatabaseHelper;
        import com.example.planningpoker.Database.Model.Question;
        import com.example.planningpoker.Database.Model.User;
        import com.example.planningpoker.R;

        import java.util.ArrayList;
        import java.util.Random;

public class ChooseFragment extends Fragment {

    public static final String TAG = "CHOOSE_FRAG";

    private View view;
    private Button btn_vote;
    private RecyclerView myRecyclerView;
    private TextView question;
    private int rand;
    private ChooseAdapter myAdapter;
    private ArrayList<String> data;
    private DatabaseHelper db;

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
        db = new DatabaseHelper(getContext());

        btn_vote = view.findViewById(R.id.btn_vote);
        myRecyclerView = view.findViewById(R.id.recycler_view_choose);
        question = view.findViewById(R.id.tv_question_choose);
        for(int i=0;i<100;i++) {
            rand = new Random().nextInt(4) + 1;
            String sad = String.valueOf(rand);
            Log.d("i",sad);
        }
        rand = 4;
        question.setText(db.getQuestion(rand).getQuestion());
        MenuActivity.btn_choose.setVisibility(View.INVISIBLE);
        MenuActivity.btn_list.setVisibility(View.INVISIBLE);
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
        myRecyclerView.setAdapter(myAdapter);

        btn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView q = view.findViewById(R.id.tv_question_choose);
                User user;
                user = db.getUser(LoginActivity.loggedUserName);
                String voteValue = data.get(myAdapter.getSelectedPosition());
                Question question = db.getQuestion(rand);

                long voted = db.insertVote(user.getId(), rand,Integer.valueOf(voteValue));
                Toast.makeText(getActivity(), "Successful vote", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + myAdapter.getItem(position) + ", which is at cell position " + position);
    }


}
