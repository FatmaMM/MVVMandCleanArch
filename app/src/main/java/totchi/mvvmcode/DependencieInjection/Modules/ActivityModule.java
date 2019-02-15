package totchi.mvvmcode.DependencieInjection.Modules;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import totchi.mvvmcode.DependencieInjection.Scopes.ActivityContext;

/**
 * Created by Fatma on 04/07/2018.
 */
@Module
public class ActivityModule {
    Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return activity;
    }
}
