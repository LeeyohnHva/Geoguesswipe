package com.example.gebruiker.geoguesswipe;
import com.example.gebruiker.geoguesswipe.R;

public class GeoObject {

    private int mGeoImageName;
    private boolean mGeoAnwser;


    public int getmGeoImageName() {
        return mGeoImageName;
    }


    public boolean getmGeoAnwser() {
        return mGeoAnwser;
    }

    public GeoObject(int index) {
        this.mGeoImageName = PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[index];
        this.mGeoAnwser = PRE_DEFINED_GEO_OBJECT_IMAGE_ANWSER[index];
    }



    public static final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

    public static final Boolean[] PRE_DEFINED_GEO_OBJECT_IMAGE_ANWSER = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false
    };
}
