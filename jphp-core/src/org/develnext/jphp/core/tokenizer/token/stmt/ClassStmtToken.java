package org.develnext.jphp.core.tokenizer.token.stmt;

import php.runtime.common.Modifier;
import org.develnext.jphp.core.tokenizer.TokenType;
import org.develnext.jphp.core.tokenizer.token.expr.value.NameToken;
import org.develnext.jphp.core.tokenizer.TokenMeta;

import java.util.ArrayList;
import java.util.List;

public class ClassStmtToken extends StmtToken {
    private Modifier modifier;
    private boolean isFinal;
    private boolean isAbstract;

    private NamespaceStmtToken namespace;
    private NameToken name;
    private ExtendsStmtToken extend;
    private ImplementsStmtToken implement;

    private MethodStmtToken constructor;
    private List<ConstStmtToken> constants;
    private List<ClassVarStmtToken> properties;
    private List<MethodStmtToken> methods;

    private boolean isInterface = false;

    public ClassStmtToken(TokenMeta meta) {
        super(meta, TokenType.T_CLASS);
        properties = new ArrayList<ClassVarStmtToken>();
        constants = new ArrayList<ConstStmtToken>();
        methods = new ArrayList<MethodStmtToken>();
    }

    public boolean isInterface() {
        return isInterface;
    }

    public void setInterface(boolean anInterface) {
        isInterface = anInterface;
    }

    public NameToken getName() {
        return name;
    }

    public void setName(NameToken name) {
        this.name = name;
    }

    public ExtendsStmtToken getExtend() {
        return extend;
    }

    public void setExtend(ExtendsStmtToken extend) {
        this.extend = extend;
    }

    public ImplementsStmtToken getImplement() {
        return implement;
    }

    public void setImplement(ImplementsStmtToken implement) {
        this.implement = implement;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
    }

    public MethodStmtToken getConstructor() {
        return constructor;
    }

    public void setConstructor(MethodStmtToken constructor) {
        this.constructor = constructor;
    }

    public List<ConstStmtToken> getConstants() {
        return constants;
    }

    public void setConstants(List<ConstStmtToken> constants) {
        this.constants = constants;
    }

    public List<ClassVarStmtToken> getProperties() {
        return properties;
    }

    public void setProperties(List<ClassVarStmtToken> properties) {
        this.properties = properties;
    }

    public List<MethodStmtToken> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodStmtToken> methods) {
        this.methods = methods;
    }

    public NamespaceStmtToken getNamespace() {
        return namespace;
    }

    public void setNamespace(NamespaceStmtToken namespace) {
        this.namespace = namespace;
    }

    public Modifier getModifier() {
        return modifier;
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    public String getFulledName(char delimiter){
        return namespace == null || namespace.getName() == null
                ? name.getName()
                : namespace.getName().toName(delimiter) + delimiter + name.getName();
    }

    public String getFulledName(){
        return getFulledName('\\');
    }
}
