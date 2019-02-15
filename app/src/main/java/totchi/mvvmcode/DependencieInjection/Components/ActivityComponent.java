package totchi.mvvmcode.DependencieInjection.Components;

import dagger.Subcomponent;
import totchi.mvvmcode.DependencieInjection.Modules.ActivityModule;
import totchi.mvvmcode.DependencieInjection.Scopes.PerActivity;
import totchi.mvvmcode.ui.Login.presentation.loginui.LoginActivity;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);
}
