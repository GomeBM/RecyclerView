package com.example.recyclerview;
import android.content.Context;

public class myData {

    static String[] nameArray = {"Goku", "Vegeta", "Piccolo", "Krillin", "Gohan", "Goten", "Trunks","Frieza", "Majin Bu", "Cell","Android 16","Android 17","Android 18","Broly","Bulma","Tien","Yamcha"};
    static String[] raceArray={"Saiyan","Saiyan","Namekian","Human","Saiyan/Human","Saiyan/Human","Saiyan/Human","Mutant","Majin","Bio-Hybrid","Android","Android","Android","Saiyan","Human","Human","Human"};
    static String[] descriptionArray;

    public static void populateShortDescriptionArray(Context context) {
        descriptionArray = new String[17];
        descriptionArray[0]=context.getString(R.string.GokuShortDescription);
        descriptionArray[1]=context.getString(R.string.VegetaShortDescription);
        descriptionArray[2]=context.getString(R.string.PiccoloShortDescription);
        descriptionArray[3]=context.getString(R.string.KrillinShortDescription);
        descriptionArray[4]=context.getString(R.string.GohanShortDescription);
        descriptionArray[5]=context.getString(R.string.GotenShortDescription);
        descriptionArray[6]=context.getString(R.string.TrunksShortDescription);
        descriptionArray[7]=context.getString(R.string.FriezaShortDescription);
        descriptionArray[8]=context.getString(R.string.MajinBuShortDescription);
        descriptionArray[9]=context.getString(R.string.CellShortDescription);
        descriptionArray[10]=context.getString(R.string.Android16ShortDescription);
        descriptionArray[11]=context.getString(R.string.Android17ShortDescription);
        descriptionArray[12]=context.getString(R.string.Android18ShortDescription);
        descriptionArray[13]=context.getString(R.string.BrolyShortDescription);
        descriptionArray[14]=context.getString(R.string.BulmaShortDescription);
        descriptionArray[15]=context.getString(R.string.TienShortDescription);
        descriptionArray[16]=context.getString(R.string.YamchaShortDescription);
    }


    static Integer[] drawableArray = {R.drawable.goku, R.drawable.vegeta, R.drawable.piccolo,
            R.drawable.krillin, R.drawable.gohan, R.drawable.goten,
            R.drawable.trunks, R.drawable.fireza, R.drawable.majinbu,R.drawable.cell,
            R.drawable.android16,R.drawable.android17,R.drawable.android18,R.drawable.broly,
            R.drawable.bulma,R.drawable.tien,R.drawable.yamcha};

    static Integer[] id_ = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16};

}
