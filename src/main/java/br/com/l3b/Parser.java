package br.com.l3b;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    private Stack<ClassDef> classDefStack;

    private String xmlFile;

    private boolean camelCase;

    public Parser(String xmlFile, boolean camelCase) {
                this.xmlFile = xmlFile;
                this.camelCase = camelCase;
    }

    public ClassDef parse() throws XMLStreamException, FileNotFoundException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFile));

        ClassDef last = null;
        while (reader.hasNext()) {
            XMLEvent xmlEvent = reader.peek();

            if (xmlEvent.isStartElement()) {
                String element = xmlEvent.asStartElement().getName().getLocalPart();
                ClassDef current = current();
                ClassDef classDef = new ClassDef(element, current, this.camelCase);
                if (current != null) {
                    append(current, classDef);
                }
                push(classDef);
            } else if (xmlEvent.isEndElement()) {
                last = pop();
                if (last.getParent() != null) {
                    last.getParent().setClassDefList(mergeDuplicates(last.getParent().getClassDefList()));
                }
            }

            reader.nextEvent();
        }

        return last;
    }

    private void push(ClassDef classDef) {
        if (this.classDefStack == null) {
            this.classDefStack = new Stack<>();
        }
        this.classDefStack.push(classDef);
    }

    private ClassDef pop() {
        if (this.classDefStack == null) {
            this.classDefStack = new Stack<>();
        }
        return this.classDefStack.pop();
    }

    private ClassDef current() {
        if (this.classDefStack == null) {
            this.classDefStack = new Stack<>();
        }
        if (!this.classDefStack.isEmpty()) {
            return this.classDefStack.peek();
        }

        return null;
    }

    private void append(ClassDef current, ClassDef classDef) {
        current.getClassDefList().add(classDef);
    }

    private List<ClassDef> mergeDuplicates(List<ClassDef> classDefList) {
        if (classDefList.size() == 1) {
            return classDefList;
        }

        List<ClassDef> mergedList = new ArrayList<>();
        Set<ClassDef> classDefSet = new LinkedHashSet<>(classDefList);
        for (ClassDef classDef : new ArrayList<>(classDefSet)) {
            List<ClassDef> duplicates = classDefList.stream().filter(c -> c.getElement().equals(classDef.getElement())).collect(Collectors.toList());
            if (duplicates.size() > 1) {
                ClassDef merged = null;
                for (ClassDef duplicate : duplicates) {
                    if (merged != null) {
                        merged.merge(duplicate);
                    } else {
                        merged = duplicate;
                    }
                }
                merged.setCollection(true);
                mergedList.add(merged);
            } else {
                mergedList.add(classDef);
            }
        }
        return mergedList;
    }
}
