package com.igs.managers;

import com.igs.utils.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    Properties props = new Properties();
    TestUtils utils = new TestUtils();

    public Properties getProps() {
        InputStream is = null;
        String propsFileName = "config.properties";

        if (props.isEmpty()) {
            try {
                utils.log().info("Cargando archivo config.properties");
                is = new FileInputStream(propsFileName);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("No se pudo cargar el archivo config.properties." + e.toString());
//                throw e;
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return props;
    }
}
