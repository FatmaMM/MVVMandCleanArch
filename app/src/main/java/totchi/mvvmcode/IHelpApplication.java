package totchi.mvvmcode;

import android.app.Application;
import android.content.Context;

import totchi.mvvmcode.DependencieInjection.Components.AppComponent;
import totchi.mvvmcode.DependencieInjection.Components.DaggerAppComponent;
import totchi.mvvmcode.DependencieInjection.Modules.ApplicationModule;

public class IHelpApplication extends Application {
    static AppComponent applicationComponent;
    private static boolean sIsChatActivityOpen = false;
    private static int userid = 0;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public AppComponent getApplicationComponent() {
        if (applicationComponent == null)
            applicationComponent = DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).build();
        return applicationComponent;
    }

    public static IHelpApplication get(Context context) {
        return (IHelpApplication) context.getApplicationContext();
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }
}
