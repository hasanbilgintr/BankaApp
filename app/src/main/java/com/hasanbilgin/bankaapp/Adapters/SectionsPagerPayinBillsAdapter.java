package com.hasanbilgin.bankaapp.Adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.PayingBills.PayingBillsBill.PayingBillsBillFragment;
import com.hasanbilgin.bankaapp.Views.PayingBills.PayingBillsCard.PayingBillsCardFragment;
import com.hasanbilgin.bankaapp.Views.PayingBills.PayingBillsIban.PayingBillsIbanFragment;
import com.hasanbilgin.bankaapp.Views.PayingBills.PayingBillsSimpleAddress.PayingBillsSimpleAddressFragment;


public class SectionsPagerPayinBillsAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES3 = new int[]{R.string.tab_payinbills_text1, R.string.tab_payinbills_text2, R.string.tab_payinbills_text3, R.string.tab_payinbills_text4};
    private final Context mContext;

    public SectionsPagerPayinBillsAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).


        if (position == 0) {
            return PayingBillsIbanFragment.newInstance();
        } else if (position == 1) {
            return PayingBillsBillFragment.newInstance();
        } else if (position == 2) {
            return PayingBillsCardFragment.newInstance();
        } else {
            return PayingBillsSimpleAddressFragment.newInstance();
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES3[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES3.length;
    }


}