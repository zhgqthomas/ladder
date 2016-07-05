package cc.cloudist.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import cc.cloudist.app.data.DataManager;
import cc.cloudist.app.ui.home.HomeActivity;
import cc.cloudist.app.ui.base.AppBaseActivity;
import cc.cloudist.app.ui.signin.SignInActivity;

import javax.inject.Inject;

public class SplashActivity extends AppBaseActivity {

    @Inject
    DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        Intent intent;
        if (TextUtils.isEmpty(mDataManager.getPreferences().getToken())) {
            intent = SignInActivity.getStartIntent(this);
        } else {
            intent = HomeActivity.getStartIntent(this, true);
        }

        startActivity(intent);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        finish();
    }
}
