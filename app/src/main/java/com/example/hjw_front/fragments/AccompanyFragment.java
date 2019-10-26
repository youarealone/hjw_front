package com.example.hjw_front.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hjw_front.R;
import com.example.hjw_front.adapters.AccompanyAdapter;
import com.example.hjw_front.utils.FragmentChanger;
import com.example.hjw_front.vo.AccompanyPostVO;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class AccompanyFragment extends Fragment {
    private FirebaseUser currentUser;

    public AccompanyFragment() {
        this.currentUser = FirebaseAuth.getInstance().getCurrentUser();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accompany, container, false);

        ArrayList<AccompanyPostVO> posts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            AccompanyPostVO post = new AccompanyPostVO(
                    i+""
                    , currentUser.getUid()
                    , currentUser.getPhotoUrl().toString()
                    , currentUser.getDisplayName()
                    , "2018.05.05"
                    , "2018.07.01"
                    , "#동행"
                    , "우후루꾸루후 슈퍼스타"
            );
            posts.add(post);
        }

        AccompanyAdapter adapter = new AccompanyAdapter(posts);
        ListView listView = view.findViewById(R.id.lv_accompany_posts);
        listView.setAdapter(adapter);

        view.findViewById(R.id.btn_accompany_write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentChanger fragmentChanger = new FragmentChanger(getFragmentManager());
                fragmentChanger.changeFragment(new WriteAccompanyFragment());
            }
        });

        return view;
    }
}
