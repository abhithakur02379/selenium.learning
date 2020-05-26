package test.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class InputRead {

    private static Properties defaultProps = new Properties();
    static
    {
        try
        {
//            String currentDir = System.getProperty("user.dir");
            String filepath= "C:/Users/login/selenium.learning/src/test/resources/input.properties";
            FileInputStream in = new FileInputStream(filepath);
            defaultProps.load(in);
            in.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key)
    {
        return defaultProps.getProperty(key);
    }
}
