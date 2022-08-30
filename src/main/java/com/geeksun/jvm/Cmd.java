package com.geeksun.jvm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.cli.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cmd {
    private boolean helpFlag;
    private boolean versionFlag;
    private boolean verboseClassFlag;
    private boolean verboseInstFlag;
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
        options.addOption("verbose_class",false,"enable verbose output");
        options.addOption("verbose_inst",false,"enable verbose output");

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
        Cmd cmd = new Cmd();
        cmd.setHelpFlag(cmdLine.hasOption("help"));
        cmd.setVersionFlag(cmdLine.hasOption("version"));
        cmd.setCpOption(cmdLine.getOptionValue("cp", ""));
        cmd.setXjreOption(cmdLine.getOptionValue("xjre", ""));
        cmd.setClassName(className);
        cmd.setArgs(tempArgs);
        cmd.setVerboseClassFlag(cmdLine.hasOption("verbose:class"));
        cmd.setVerboseInstFlag(cmdLine.hasOption("verbose:inst"));
        return cmd;
    }

    public static void printUsage(Cmd cmd){
        System.out.printf("Usage: %s [-options] class [args...]\n", cmd.getClassName());
    }

}
