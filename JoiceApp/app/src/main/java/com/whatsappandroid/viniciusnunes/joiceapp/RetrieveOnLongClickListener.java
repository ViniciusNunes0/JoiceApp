package com.whatsappandroid.viniciusnunes.joiceapp;

import android.view.View;
import android.widget.Toast;

/**
 * Created by Vinicius Nunes on 21/12/2017.
 */

public class RetrieveOnLongClickListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(v.getContext(),"Clicado ihihiihihhihi",Toast.LENGTH_LONG).show();

        return false;
    }
}
