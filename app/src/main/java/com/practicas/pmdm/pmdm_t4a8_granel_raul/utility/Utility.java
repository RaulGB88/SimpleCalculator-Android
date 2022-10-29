package com.practicas.pmdm.pmdm_t4a8_granel_raul.utility;

import android.widget.Spinner;

public class Utility {
    public String getSelectedSpinnerItem(Spinner spinner) {
        String item = "";
        item = spinner.getSelectedItem().toString();
        return item;
    }

    public Boolean checkNumber(String number) {
        boolean isNumber = true;
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            isNumber = false;
        }
        return isNumber;
    }
}
