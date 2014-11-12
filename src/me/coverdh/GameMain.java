package me.coverdh;

import me.coverdh.Util.Config;

/**
 * 游戏主函数
 * Created by dhcover on 14/11/12.
 */
public class GameMain {
    public static void main(String[] args) {
        System.out.println("Starting Game Server");
        String configPath = "config/config.properties";
        if (args.length%2 == 1){
            System.out.printf("args length not match");
            return ;
        }
        for (int i=0;i<args.length/2;i++){
            if (args[i*2].equals("config")){
                configPath = args[i*2+1];

            }else{
                System.out.printf("illegal option -- %s\nusage: server [config path|...] ", args[i * 2]);
            }
        }
        Config.instance().loadConfig(configPath);

    }
}
