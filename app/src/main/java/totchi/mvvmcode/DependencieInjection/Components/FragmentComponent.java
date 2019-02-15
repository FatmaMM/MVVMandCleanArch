package totchi.mvvmcode.DependencieInjection.Components;

import dagger.Subcomponent;
import totchi.mvvmcode.DependencieInjection.Modules.FragmentModule;
import totchi.mvvmcode.DependencieInjection.Scopes.PerFragment;

/**
 * Created by Fatma on 04/07/2018.
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
}
