package com.geeksun.jvm;

import com.geeksun.jvm.classpath.Classpath;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            Cmd cmd = Cmd.parseCmd(args);
            if(cmd.isVersionFlag()){
                System.out.println("version 0.0.1");
            } else if (cmd.isHelpFlag()||cmd.getClassName().equals("")) {
                Cmd.printUsage(cmd);
            }else{
                startJVM(cmd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void startJVM(Cmd cmd){
        Classpath cp = new Classpath(cmd.getXjreOption(), cmd.getCpOption());
        System.out.printf("classpath:%s class:%s args:%s", cp, cmd.getClassName(), String.join(" ", cmd.getArgs()));

        String className = cmd.getClassName().replace(".", "/");
        byte[] data = cp.readClass(className);
        if(data == null){
            System.out.printf("Could not find or load main class %s%n", cmd.getClassName());
        }
        System.out.println("class data:" + Arrays.toString(data));

    }

}
