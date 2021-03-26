package br.com.l3b;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Generator {

    private String templateFile;

    private String xmlFile;

    private String generatedDirectory;

    private String packageName;

    private String classPrefix;

    private boolean camelCase;

    public Generator(String templateFile, String xmlFile, String generatedDirectory, String packageName, String classPrefix, boolean camelCase) {
        this.templateFile = templateFile;
        this.xmlFile = xmlFile;
        this.generatedDirectory = generatedDirectory;
        this.packageName = packageName;
        this.classPrefix = classPrefix;
        this.camelCase = camelCase;
    }

    public void generate(ClassDef classDef) throws Exception {
        createDir();
        generateClass(classDef);
    }

    private void generateClass(ClassDef classDef) throws Exception {
        if (classDef.getClassDefList().size() > 0) {
            processTemplate(classDef);

            for (ClassDef field : classDef.getClassDefList()) {
                generateClass(field);
            }
        }
    }

    private void processTemplate(ClassDef classDef) throws Exception {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        Template t = velocityEngine.getTemplate(this.templateFile);

        VelocityContext context = new VelocityContext();
        context.put("package", this.packageName);
        context.put("className", getClassName(classDef.getElementFormattedToTypeName()));
        context.put("classPrefix", this.classPrefix);
        context.put("classDef", classDef);
        context.put("fields", classDef.getClassDefList());

        StringWriter writer = new StringWriter();
        t.merge(context, writer);

        createFile(Paths.get(this.generatedDirectory, getClassName(classDef.getElementFormattedToTypeName()) + ".java").toString(), writer.toString());
    }

    private Object getClassName(String elementName) {
        return this.classPrefix + elementName;
    }

    private void createDir() throws IOException {
        File theDir = new File(this.generatedDirectory);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        FileUtils.cleanDirectory(new File(this.generatedDirectory));
    }

    private void createFile(String filepath, String content) throws IOException {
        int i = 1;
        while (new File(filepath).exists()) {
            filepath = filepath + i;
        }

        FileUtils.writeStringToFile(new File(filepath), content, UTF_8);

        System.out.println("Create class: " + filepath);
    }
}
