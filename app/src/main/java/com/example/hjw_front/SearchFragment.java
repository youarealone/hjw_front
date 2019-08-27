package com.example.hjw_front;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        setHashtags(view);

        return view;
    }

    private void setHashtags(View view) {
        String[] hashtags = {
                "#제주핫플", "#제주여행", "#바다", "#함덕", "#세화", "#애월", "#제주오름", "#제주카페", "제주혼행"
        };

        LinearLayout container = view.findViewById(R.id.container_hashtags);

        for (String hashtag: hashtags) {
            TextView textView = new TextView(getContext());
            textView.setText(hashtag);

            container.addView(textView);
        }
    }
}
