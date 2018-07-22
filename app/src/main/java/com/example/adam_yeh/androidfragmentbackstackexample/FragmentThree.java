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
public class FragmentThree extends Fragment {

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_back_stack_three, container, false);

        final FragmentManager fragmentManager = super.getFragmentManager();

        Button gotoFragmentOneBtn = (Button) retView.findViewById(R.id.fragment_back_stack_three_button);
        gotoFragmentOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                String fragmentName = "Fragment One";
                Fragment fragmentOne = FragmentUtil.getFragmentByTagName(fragmentManager, fragmentName);

                if (fragmentOne == null) {fragmentOne = new FragmentOne();}

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_back_stack_frame_layout, fragmentOne, fragmentName);
                transaction.addToBackStack(null);
                transaction.commit();

                FragmentUtil.printActivityFragmentList(fragmentManager);
            }
        });

        return retView;
    }

}
