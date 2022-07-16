package com.geeksun.jvm;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.cli.*;

@Data
@AllArgsConstructor
public class Cmd {
    private boolean helpFlag;
    private boolean versionFlag;
    private String cpOption;
    private String XjreOption;
    private String className;
    private String[] args;

    public static Cmd parseCmd(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("?", "help",false,"print help message");
        options.addOption("version", false,"print version and exit");
        options.addOption("cp", "classpath", true, "classpath");
        options.addOption("Xjre",true,"path to jre");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = parser.parse(options, args);
        String[] cmdArgs = cmdLine.getArgs();
        String className = null;
        String[] tempArgs = null;
        if(cmdArgs.length > 0){
            className = cmdArgs[0];
            tempArgs = new String[cmdArgs.length - 1];
            System.arraycopy(cmdArgs, 1, tempArgs, 0, tempArgs.length);
        }
        return new Cmd(cmdLine.hasOption("help"), cmdLine.hasOption("version"), cmdLine.getOptionValue("cp", ""), cmdLine.getOptionValue("xjre", ""), className, tempArgs);
    }

    public static void printUsage(Cmd cmd){
        System.out.printf("Usage: %s [-options] class [args...]\n", cmd.getClassName());
    }

}
