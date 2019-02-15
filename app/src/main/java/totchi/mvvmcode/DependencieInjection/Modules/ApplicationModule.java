package totchi.mvvmcode.DependencieInjection.Modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import totchi.mvvmcode.Data.DataManger;
import totchi.mvvmcode.Data.Model.RemoteService.IHelpService;

/**
 * Created by Fatma on 04/07/2018.
 */
@Module
public class ApplicationModule {
    Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Singleton
    @Provides
    IHelpService provideService() {
        return IHelpService.Creator.newIHelpService();
    }

    @Provides
    DataManger provideDatamanger(IHelpService service) {
        return new DataManger(service);
    }
}
