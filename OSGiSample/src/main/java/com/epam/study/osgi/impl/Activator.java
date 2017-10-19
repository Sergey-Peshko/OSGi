package com.epam.study.osgi.impl;

import com.epam.study.osgi.Greeting;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("service impl start");
        bundleContext.registerService(Greeting.class.getName(), new GreetingImpl("service"), null);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("service impl stop");
    }
}
