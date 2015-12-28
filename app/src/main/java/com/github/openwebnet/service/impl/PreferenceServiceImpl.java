package com.github.openwebnet.service.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.openwebnet.component.Injector;
import com.github.openwebnet.service.PreferenceService;

import javax.inject.Inject;

public class PreferenceServiceImpl implements PreferenceService {

    private static final String PREFERENCE_MAIN = "com.github.openwebnet.MAIN";
    private static final String KEY_FIRST_RUN = "com.github.openwebnet.MAIN.FIRST_RUN";

    private final SharedPreferences sharedPreferences;

    @Inject
    Context context;

    public PreferenceServiceImpl() {
        Injector.getApplicationComponent().inject(this);
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_MAIN, Context.MODE_PRIVATE);
    }

    @Override
    public boolean isFirstRun() {
        return sharedPreferences.getBoolean(KEY_FIRST_RUN, true);
    }

    @Override
    public void initFirstRun() {
        sharedPreferences.edit().putBoolean(KEY_FIRST_RUN, false).apply();
    }
}
