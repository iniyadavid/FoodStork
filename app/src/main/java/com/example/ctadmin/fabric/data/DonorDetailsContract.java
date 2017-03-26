package com.example.ctadmin.fabric.data;


import android.provider.BaseColumns;

public final class DonorDetailsContract {
    private DonorDetailsContract() {
    }

    public static final class DonorDetailsEntry implements BaseColumns {

        public static final String TABLE_NAME = "donor_details";
        public final static String _ID = BaseColumns._ID;
        public static final String COLUMN_DONOR_NAME = "donor_name";
        public static final String COLUMN_DONOR_ADDRESS = "donor_address";
        public static final String COLUMN_DONOR_CONTACT = "donor_contact";
        public static final String COLUMN_DONOR_EMAIL = "donor_email";
    }
}
