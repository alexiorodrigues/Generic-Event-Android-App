package com.partnersincrime.foxdarkmaster.geekeventsmobileapp.Managers;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

/**
 * Created by foxdarkmaster on 19-06-2016.
 */
public class LocaleManager {
    private static final String TAG = "LOCALE-MANAGER";

    public static void loadLocale(Context context) {
        if (getCurrentLocale(context).startsWith("pt")){
            setLocale(context, "pt");
        } else {
            setLocale(context, "en");
        }
    }

    private static void setLocale(Context context, String locale){
        SPManager.setLocale(context, locale);
        Locale loc = new Locale(locale);
        Locale.setDefault(loc);
        Configuration cfg = new Configuration();
        cfg.locale = loc;
        context.getResources().updateConfiguration(cfg, null);
    }

    public static String getCurrentLocale(Context context){
        return context
                .getResources()
                .getConfiguration()
                .locale
                .toString();
    }
}
