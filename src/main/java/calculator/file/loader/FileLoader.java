package calculator.file.loader;

import org.apache.commons.cli.*;

import java.io.File;

public class FileLoader {
    public File getInstructionFile(String[] args) {
        String pathToFile;
        CommandLine commandLine = null;
        Options options = new Options();
        Option option = new Option("f", "file", true, "input file");
        options.addOption(option);

        CommandLineParser parser = new BasicParser();
        try {
            commandLine = parser.parse(options, args);
        } catch (org.apache.commons.cli.ParseException e) {
            e.printStackTrace();
        }

        if (commandLine != null && commandLine.hasOption("f"))
            pathToFile = commandLine.getOptionValue("f");
        else
            pathToFile = FileLoader.class.getClassLoader().getResource("instructions.txt").getFile();
        return new File(pathToFile);
    }
}
