package com.epam.study.osgi.client;

import com.epam.study.osgi.Greeting;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Client implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Client start");
        ServiceReference ref = bundleContext.getServiceReference(Greeting.class.getName());

        ((Greeting) bundleContext.getService(ref)).sayHello();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Client stop");
    }
}
