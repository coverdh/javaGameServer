package me.coverdh;


public class Main {

    public static void main(String[] args) {
        String [] argsSub =null;
        if (args.length >1) {
            argsSub = new String[args.length - 1];
            for (int i=0;i<args.length-1;i++){
                argsSub[i] = args[i-1];
            }
        }
        if (args.length == 0 || args[0].equals("server")){
            GameMain.main(argsSub);
        }else{
            if (args[0].equals("client")){
                TestMain.main(argsSub);
            }else if(args[0].equals("template")){
                TemplateTool.main(argsSub);
            }else{
                System.out.printf("illegal option -- %s\nusage: [server|client|template] ",args[0]);
            }
        }

    }
}
