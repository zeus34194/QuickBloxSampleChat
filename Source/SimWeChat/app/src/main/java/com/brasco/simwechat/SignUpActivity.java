package com.brasco.simwechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

//import com.bumptech.glide.Glide;
//import com.nguyenhoanglam.imagepicker.activity.ImagePicker;
//import com.nguyenhoanglam.imagepicker.activity.ImagePickerActivity;
//import com.nguyenhoanglam.imagepicker.model.Image;

import com.brasco.simwechat.countrypicker.CountryPicker;
import com.brasco.simwechat.countrypicker.CountryPickerListener;
import com.brasco.simwechat.utils.Utils;
import com.bumptech.glide.util.Util;

import java.io.File;
import java.util.ArrayList;

public class SignUpActivity extends IBActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_PICKER = 100;
    private ImageButton m_btnSelectAvatar = null;
//    private ArrayList<Image> m_imgAvatarList = new ArrayList<>();
    private EditText m_txtFullName = null;
    private LinearLayout m_btnSelectCountry = null;
    private TextView m_txtCountry = null;
    private EditText m_txtDialCode = null;
    private EditText m_txtMobileNumber = null;
    private EditText m_txtPassword = null;
    private ToggleButton m_btnShowPassword = null;
    private Button m_btnSignUp = null;

    private CountryPicker m_CountryPicker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        m_btnSelectAvatar = (ImageButton) findViewById(R.id.btn_select_avatar);
        m_txtFullName = (EditText) findViewById(R.id.txt_full_name);
        m_btnSelectCountry = (LinearLayout) findViewById(R.id.btn_select_country);
        m_txtCountry = (TextView) findViewById(R.id.txt_country);
        m_txtDialCode = (EditText) findViewById(R.id.txt_dial_code);
        m_txtMobileNumber = (EditText) findViewById(R.id.txt_phone_number);
        m_txtPassword = (EditText) findViewById(R.id.txt_input_password);
        m_btnShowPassword = (ToggleButton) findViewById(R.id.btn_show_password);
        m_btnSignUp = (Button) findViewById(R.id.button_sign_up);
        m_btnSelectAvatar.setOnClickListener(this);
        m_btnSelectCountry.setOnClickListener(this);
        m_btnShowPassword.setOnClickListener(this);
        m_btnSignUp.setOnClickListener(this);

        m_CountryPicker = CountryPicker.newInstance("Select Region");
        m_CountryPicker.setListener(new CountryPickerListener() {
            @Override
            public void onSelectCountry(String name, String code) {
                m_txtCountry.setText(name);
                String strDialCode = "999";
                if (Utils.Country2DialCode.containsKey(code))
                    strDialCode = Utils.Country2DialCode.get(code);
                m_txtDialCode.setText(strDialCode);
                m_CountryPicker.dismiss();
            }
        });

        ActionBar("Sign Up");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICKER && resultCode == RESULT_OK && data != null) {
//            m_imgAvatarList = data.getParcelableArrayListExtra(ImagePickerActivity.INTENT_EXTRA_SELECTED_IMAGES);
//            if (m_imgAvatarList.size() > 0) {
//                Image imgAvatar = m_imgAvatarList.get(0);
//                String imgPath = imgAvatar.getPath();
//                Glide.with(this).load(Uri.fromFile(new File(imgPath))).into(m_btnSelectAvatar);
//            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_select_avatar:
                showImageFileChooser();
                break;
            case R.id.btn_select_country:
                m_CountryPicker.show(getSupportFragmentManager(), "COUNTRY_PICKER");
                break;
            case R.id.btn_show_password:
                break;
            case R.id.button_sign_up:
                break;
        }
    }

    private void showImageFileChooser() {
//        ImagePicker.create(this)
//                .folderMode(true) // folder mode (false by default)
//                .folderTitle("Folder") // folder selection title
//                .imageTitle("Select Avatar") // image selection title
//                .single() // single mode
//                .multi() // multi mode (default mode)
//                .limit(1) // max images can be selected (99 by default)
//                .showCamera(true) // show camera or not (true by default)
//                .imageDirectory("Camera") // directory name for captured image  ("Camera" folder by default)
//                .origin(m_imgAvatarList) // original selected images, used in multi mode
//                .start(REQUEST_CODE_PICKER); // start image picker activity with request code

    }
}
