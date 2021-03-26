package br.com.l3b;

import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String templateFile = "templates/java-class.vm", xmlFile = null, generatedDirectory = null, packageName = "br.com.l3b", classPrefix = "L3B";
        boolean camelCase = false;

        Options options = new Options();
        options.addOption(Option.builder("t")
                .longOpt("template")
                .hasArg(true)
                .desc("java class velocity template")
                .required(false)
                .build());
        options.addOption(Option.builder("x")
                .longOpt("xml")
                .hasArg(true)
                .desc("xml archive")
                .required(true)
                .build());
        options.addOption(Option.builder("g")
                .longOpt("generated")
                .hasArg(true)
                .desc("generated files directory")
                .required(true)
                .build());
        options.addOption(Option.builder("p")
                .longOpt("package")
                .hasArg(true)
                .desc("java package")
                .required(true)
                .build());
        options.addOption(Option.builder("c")
                .longOpt("classPrefix")
                .hasArg(true)
                .desc("java class name prefix")
                .required(true)
                .build());
        options.addOption(Option.builder("l")
                .longOpt("camel")
                .hasArg(false)
                .desc("convert element name to camel case")
                .required(false)
                .build());

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
            if (cmd.hasOption("t")) {
                templateFile = cmd.getOptionValue("t");
            }
            if (cmd.hasOption("x")) {
                xmlFile = cmd.getOptionValue("x");
            }
            if (cmd.hasOption("g")) {
                generatedDirectory = cmd.getOptionValue("g");
            }
            if (cmd.hasOption("p")) {
                packageName = cmd.getOptionValue("p");
            }
            if (cmd.hasOption("c")) {
                classPrefix = cmd.getOptionValue("c");
            }
            if (cmd.hasOption("l")) {
                camelCase = true;
            }
        } catch (ParseException pe) {
            System.out.println("Error parsing command-line arguments!");
            System.out.println("Please, follow the instructions below:");
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Log messages to sequence diagrams converter", options);
            System.exit(1);
        }

        ClassDef classDef = new Parser(xmlFile, camelCase).parse();
        new Generator(templateFile, xmlFile, generatedDirectory, packageName, classPrefix, camelCase).generate(classDef);
    }

}
