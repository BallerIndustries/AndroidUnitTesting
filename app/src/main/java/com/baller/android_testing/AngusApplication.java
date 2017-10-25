package com.baller.android_testing;

import android.app.Application;
import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.configuration.Configuration;
import toothpick.registries.FactoryRegistryLocator;
import toothpick.registries.MemberInjectorRegistryLocator;
import toothpick.smoothie.module.SmoothieApplicationModule;


/**
 * Created by anguruso on 25/10/2017.
 */

public class AngusApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // com.example.smoothie.MemberInjectorRegistry and com.example.smoothie.FactoryRegistry are classes generated by this project
        // Your project will have these classes in your package (or the one you specify).
        // Please note that the fully qualified name should be used instead of an import.
        // (see https://github.com/stephanenicolas/toothpick/wiki/Factory-and-Member-Injector-registries)
        // If you're not using the reflection free configuration, the next 3 lines can be omitted
        Toothpick.setConfiguration(Configuration.forProduction().disableReflection());
        MemberInjectorRegistryLocator.setRootRegistry(new com.baller.android_testing.MemberInjectorRegistry());
        FactoryRegistryLocator.setRootRegistry(new com.baller.android_testing.FactoryRegistry());

        // Toothpick
        Scope appScope = Toothpick.openScope(this);
        appScope.installModules(new SmoothieApplicationModule(this));
    }
}
