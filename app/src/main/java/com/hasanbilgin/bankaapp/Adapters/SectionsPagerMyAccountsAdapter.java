package com.hasanbilgin.bankaapp.Adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.AllTransactions.AllTransactionsFragment;
import com.hasanbilgin.bankaapp.Views.HomePage.HomePageFragment;
import com.hasanbilgin.bankaapp.Views.MyAssets.MyAssetsFragment;
import com.hasanbilgin.bankaapp.Views.MySettings.MySettingsFragment;


public class SectionsPagerMyAccountsAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES2 = new int[]{R.string.tab_bankstatement_text1, R.string.tab_bankstatement_text2,R.string.tab_bankstatement_text3,R.string.tab_bankstatement_text4};
    private final Context mContext;

    public SectionsPagerMyAccountsAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        if (position == 0) {
            return HomePageFragment.newInstance();
        } else if (position == 1) {
            return MyAssetsFragment.newInstance();
        } else if (position == 2) {
            return MySettingsFragment.newInstance();
        } else {
            return AllTransactionsFragment.newInstance();
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES2[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES2.length;
    }


}