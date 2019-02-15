package totchi.mvvmcode.DependencieInjection.Components;

import dagger.Component;
import totchi.mvvmcode.DependencieInjection.Modules.ActivityModule;
import totchi.mvvmcode.DependencieInjection.Modules.FragmentModule;
import totchi.mvvmcode.DependencieInjection.Scopes.ConfigPersistent;

/**
 * Created by Fatma on 04/07/2018.
 */
@ConfigPersistent
@Component(dependencies = AppComponent.class)
public interface ConfigPersistentComponent {
    FragmentComponent fragmentComponent(FragmentModule fragmentModule);

    ActivityComponent activityComponent(ActivityModule activityModule);
}
