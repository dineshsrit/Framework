package org.selenium.pom.utilis;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.apache.commons.lang3.ObjectUtils;
import org.selenium.pom.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    public ConfigLoader() {

        String env=System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env))
        {
            case STAGE:
                properties = PropertyUtils.propertyLoader("src/test/Resources/stg_config.properties");
                break;
            case PRODUCTION:
                properties = PropertyUtils.propertyLoader("src/test/Resources/prod_config.properties");
                break;
            default: throw new IllegalStateException("Invalid env type: "+ env);
        }


    }
    public static ConfigLoader getInstance()
    {
        if(configLoader == null)
        {
            configLoader=new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl()
    {
        String prop=properties.getProperty("baseUrl");
        if(prop!=null) return prop;
        else throw new RuntimeException("Property baseUrl is not specified in the property file");
    }

}
