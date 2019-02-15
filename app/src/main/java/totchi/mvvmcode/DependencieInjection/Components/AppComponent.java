package totchi.mvvmcode.DependencieInjection.Components;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import totchi.mvvmcode.Data.DataManger;
import totchi.mvvmcode.DependencieInjection.Modules.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface AppComponent {
    Application application();

    DataManger dataManager();

}
