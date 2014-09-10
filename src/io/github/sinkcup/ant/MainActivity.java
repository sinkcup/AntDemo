package io.github.sinkcup.ant;

import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.widget.TextView;

/**
 * main
 */
public class MainActivity extends Activity {

    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UmengUpdateAgent.update(this);
        setContentView(R.layout.activity_main);

        try {
            String packageName = getPackageName();
            ((TextView) findViewById(R.id.package_name)).setText(packageName);

            String versionCode = Integer.toString(getPackageManager()
                    .getPackageInfo(getPackageName(), 0).versionCode);
            ((TextView) findViewById(R.id.version_code)).setText(versionCode);

            String versionName = getPackageManager().getPackageInfo(
                    getPackageName(), 0).versionName;
            ((TextView) findViewById(R.id.version_name)).setText(versionName);

            ApplicationInfo ai = getPackageManager().getApplicationInfo(
                    getPackageName(), PackageManager.GET_META_DATA);
            String umengChannel = ai.metaData.get("UMENG_CHANNEL").toString();
            ((TextView) findViewById(R.id.umeng_channel)).setText(umengChannel);

        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public final boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public final void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public final void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

}
