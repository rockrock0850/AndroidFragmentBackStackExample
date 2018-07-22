package com.example.adam_yeh.androidfragmentbackstackexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author adam_yeh
 * @date 7/5/18
 */
public class FragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_back_stack_two, container, false);

        final FragmentManager fragmentManager = super.getFragmentManager();

        Button gotoFragmentThreeBtn = (Button) retView.findViewById(R.id.fragment_back_stack_two_button);
        gotoFragmentThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                String fragmentName = "Fragment Three";
                Fragment fragmentThree = FragmentUtil.getFragmentByTagName(fragmentManager, fragmentName);

                if (fragmentThree == null) {fragmentThree = new FragmentThree();}

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_back_stack_frame_layout, fragmentThree, fragmentName);
                transaction.addToBackStack(null);
                transaction.commit();

                FragmentUtil.printActivityFragmentList(fragmentManager);
            }
        });

        return retView;
    }

}
