import org.osgi.framework.*;
import org.apache.felix.framework.Felix;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Felix framework;

    public static void main(String[] args) {
        try {

            final Map configMap = new HashMap();
            configMap.put(Constants.FRAMEWORK_STORAGE_CLEAN, "onFirstInit");

            framework = new Felix(configMap);
            framework.init();

            final BundleContext context = framework.getBundleContext();

            Bundle provider = context.installBundle("file:/home/siarhei/EDU Projects/OSGi/OSGiMain/src/main/resources/bundles/OSGiSample-1.0-SNAPSHOT.jar");
            Bundle consumer = context.installBundle("file:/home/siarhei/EDU Projects/OSGi/OSGiMain/src/main/resources/bundles/OSGiClientSample-1.0-SNAPSHOT.jar");

            framework.start();

            provider.start();
            consumer.start();
            consumer.stop();
            provider.stop();

            framework.stop();

            System.exit(0);

        } catch (Exception ex) {
            System.out.println(ex);
            System.exit(0);
        }
    }

}
