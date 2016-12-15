package com.brasco.simwechat.quickblox.core.ui.activity;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

import com.quickblox.core.exception.QBResponseException;

import java.lang.reflect.Field;

public class CoreBaseActivity extends AppCompatActivity {
    public static final String TAG = CoreBaseActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hack. Forcing overflow button on actionbar on devices with hardware menu button
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception ex) {
            // Ignore
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T _findViewById(int viewId) {
        return (T) findViewById(viewId);
    }

    public void setActionBarTitle(int title) {
    }

    public void setActionBarTitle(CharSequence title) {
    }

    protected void fillField(TextView textView, String value) {
        textView.setText(value);
    }

    protected void showSnackbarError(View rootLayout, @StringRes int resId, QBResponseException e, View.OnClickListener clickListener) {
//        ErrorUtils.showSnackbar(rootLayout, resId, e, R.string.dlg_retry, clickListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
