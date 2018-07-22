package com.example.adam_yeh.androidfragmentbackstackexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import java.util.List;

/**
 * @author adam_yeh
 * @date 7/5/18
 */
public class FragmentUtil {

    public final static String CLAZZ_NAME = FragmentUtil.class.getSimpleName();

    // Get exist Fragment by it's tag name.
    public static Fragment getFragmentByTagName (FragmentManager fragmentManager, String fragmentTagName) {
        Fragment ret = null;

        // Get all Fragment list.
        List<Fragment> fragmentList = fragmentManager.getFragments();

        if (fragmentList != null) {
            int size = fragmentList.size();

            for (Fragment fragment : fragmentList) {
                if (fragment != null) {
                    String fragmentTag = fragment.getTag();

                    // If Fragment tag name is equal then return it.
                    if (fragmentTag.equals(fragmentTagName)) {
                        ret = fragment;
                    }
                }
            }
        }

        return ret;
    }

    // Print fragment manager managed fragment in debug log.
    public static void printActivityFragmentList (FragmentManager fragmentManager) {
        int fragmentCount = fragmentManager.getBackStackEntryCount();

        Log.d(CLAZZ_NAME, String.valueOf(fragmentCount));

        for (int i = 0; i < fragmentCount; i++) {
            String fragmentName = fragmentManager.getBackStackEntryAt(i).getName();
            Log.d(CLAZZ_NAME, fragmentName  == null ? "" : fragmentName);
        }
    }

}
