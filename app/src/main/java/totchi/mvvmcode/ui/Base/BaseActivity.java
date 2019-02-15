package totchi.mvvmcode.ui.Base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.LongSparseArray;

import java.util.concurrent.atomic.AtomicLong;

import totchi.mvvmcode.DependencieInjection.Components.ActivityComponent;
import totchi.mvvmcode.DependencieInjection.Components.ConfigPersistentComponent;
import totchi.mvvmcode.DependencieInjection.Components.DaggerConfigPersistentComponent;
import totchi.mvvmcode.DependencieInjection.Modules.ActivityModule;
import totchi.mvvmcode.IHelpApplication;

/**
 * Created by Fatma on 03/07/2018.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private static final LongSparseArray<ConfigPersistentComponent>
            sComponentsMap = new LongSparseArray<>();


    private ActivityComponent mActivityComponent;
    private long mActivityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the ActivityComponent and reuses cached ConfigPersistentComponent if this is
        // being called after a configuration change.
        mActivityId = savedInstanceState != null ?
                savedInstanceState.getLong(KEY_ACTIVITY_ID) : NEXT_ID.getAndIncrement();

        ConfigPersistentComponent configPersistentComponent = sComponentsMap.get(mActivityId, null);

        if (configPersistentComponent == null) {
            configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .appComponent(IHelpApplication.get(this).getApplicationComponent())
                    .build();
            sComponentsMap.put(mActivityId, configPersistentComponent);
        }
        mActivityComponent = configPersistentComponent.activityComponent(new ActivityModule(this));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_ACTIVITY_ID, mActivityId);
    }

    @Override
    protected void onDestroy() {
        if (!isChangingConfigurations()) {
            sComponentsMap.remove(mActivityId);
        }
        super.onDestroy();
    }

    public ActivityComponent activityComponent() {
        return mActivityComponent;
    }

}
