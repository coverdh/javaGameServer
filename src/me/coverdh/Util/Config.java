package me.coverdh.Util;

import me.coverdh.exception.GameServerStartupException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Properties;
/**
 * 配置文件读取类
 * 采用Properties
 *
 * Created by dhcover on 14/11/12.
 */
public class Config {
    private static final Log Logger = LogFactory.getLog(Config.class);

    private static Config config = new Config();
    private final Properties properties = new Properties();
    Map<String, Class> propNameList = new LinkedHashMap<String,Class>(){{
        put("server.port", Integer.class);
        put("server.ip",String.class);
    }};
    Map<String,Object> propList = new LinkedHashMap<String, Object>(){{
        put("server.port",2000);
        put("server.ip","127.0.0.1");
    }};
    private Config() {}

    /**
     * @return
     */
    public static Config instance() {
        return config;
    }
    public void loadConfig(String path){
        propList.clear();
        InputStream in = null;
        try {
            final File file = new File(path);
            if (!file.exists()) {
                throw new GameServerStartupException("File " + path + " is not exists");
            }
            in = new FileInputStream(file);
            properties.load(in);
            for(Map.Entry<String,Class> kv:propNameList.entrySet()){
                if (properties.contains(kv.getKey())) {
                    if (kv.getValue() == Integer.class) {
                        propList.put(kv.getKey(), Integer.parseInt(properties.getProperty(kv.getKey(), "0")));
                    } else if (kv.getValue() == String.class) {
                        propList.put(kv.getKey(), properties.getProperty(kv.getKey(), ""));
                    }
                }
            }

        }
        catch (Exception e) {
            System.err.println("Error reading config properties in PropertyManager.loadProps() " + e);
            Logger.error(e);
        }
        finally {
            try {
                in.close();
            } catch (Exception e) { }
        }
    }

    public int getInteger(String key){
        int val = 0;
        if (propList.containsKey(key) && propList.get(key).getClass() == Integer.class){
            val = (Integer)propList.get(key);
        }
        return val;
    }

    public String getString(String key){
        String val = "";
        if (propList.containsKey(key)){
            val = propList.get(key).toString();
        }
        return val;
    }

}
