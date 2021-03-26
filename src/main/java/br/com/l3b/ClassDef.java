package br.com.l3b;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class ClassDef {

    private String element;

    private List<ClassDef> classDefList = new ArrayList<>();

    private ClassDef parent;

    private boolean isCollection = false;

    private String elementPrefix;

    private boolean camelCase;

    public ClassDef(String name, ClassDef parent, boolean camelCase) {
        this.element = name;
        this.parent = parent;
        this.camelCase = camelCase;
    }

    public String getElement() {
        return this.element;
    }

    public String getElementFormatted() {
        if (this.camelCase) {
            return toCamelCase(this.getElement());
        }
        return this.getElement();
    }

    public String getElementFormattedToTypeName() {
        return getElementFormatted().substring(0, 1).toUpperCase() + getElementFormatted().substring(1);
    }

    public void setElement(String element) {
        this.element = element;
    }

    public List<ClassDef> getClassDefList() {
        return classDefList;
    }

    public void setClassDefList(List<ClassDef> classDefList) {
        this.classDefList = classDefList;
    }

    public ClassDef getParent() {
        return parent;
    }

    public void setParent(ClassDef parent) {
        this.parent = parent;
    }

    public boolean isCollection() {
        return this.isCollection;
    }

    public boolean getIsCollection() {
        return this.isCollection;
    }

    public void setCollection(boolean collection) {
        this.isCollection = collection;
    }

    public String getElementPrefix() {
        return this.elementPrefix;
    }

    public void setElementPrefix(String elementPrefix) {
        this.elementPrefix = elementPrefix;
    }

    public boolean getIsObject() {
        return this.classDefList.size() > 0;
    }

    public String path() {
        if (parent != null) {
            if (isCollection()) {
                return parent.path() + "/" + this.element + "[pos" + depth() + "]";
            } else {
                return parent.path() + "/" + this.element;
            }
        }
        return "/" + this.element;
    }

    public List<String> getPathPositions() {
        String[] positions = StringUtils.substringsBetween(path(), "[", "]");
        if (positions != null) {
            return new ArrayList<>(Arrays.asList(positions));
        } else {
            return new ArrayList<>();
        }
    }

    public String pathWithStringFormat() {
        String path = path();
        for (String position : getPathPositions()) {
            path = path.replace(position, "%d");
        }
        return path;
    }

    public int depth() {
        if (parent != null) {
            return parent.depth() + 1;
        }
        return 1;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        String tabSequence = tabSequence(this.depth());
        buffer.append(tabSequence);
        buffer.append(this.path());
        if (!classDefList.isEmpty()) {
            buffer.append("\n").append(tabSequence(this.depth())).append("[").append("\n");
            for (int i = 0; i < classDefList.size(); i++) {
                buffer.append(classDefList.get(i).toString());
                if (classDefList.size() - 1 > i) {
                    buffer.append(",\n");
                }
            }
            buffer.append("\n").append(tabSequence(this.depth())).append("]");
        }
        return buffer.toString();
    }

    private String tabSequence(int quantity) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < quantity; i++) {
            buffer.append("    ");
        }
        return buffer.toString();
    }

    public void merge(ClassDef other) {
        List<ClassDef> newClassDefList = new ArrayList<>();
        for (ClassDef otherClassDef : other.classDefList) {
            Optional<ClassDef> foundClassDef = this.classDefList.stream().filter(c -> c.getElement().equals(otherClassDef.getElement())).findFirst();
            if (foundClassDef.isPresent()) {
                foundClassDef.get().merge(foundClassDef.get());
                newClassDefList.add(foundClassDef.get());
            } else {
                newClassDefList.add(otherClassDef);
            }
        }
        this.setClassDefList(newClassDefList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassDef classDef = (ClassDef) o;
        return element.equals(classDef.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }

    private String toCamelCase(String name) {
        name = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }
}
