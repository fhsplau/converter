/**
 * Created by kacprzakp on 1/3/14.
 */

import java.io.File;
import java.util.ResourceBundle;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.mylib.converter.keywords.Bin2Dec;
import com.mylib.converter.keywords.Dec2Bin;
import org.robotframework.javalib.library.AnnotationLibrary;

public class Converter extends AnnotationLibrary{
    public static final String KEYWORD_PATTERN = "com/mylib/converter/keywords/*.class";
    public static final String ROBOT_LIBRARY_DOC_FORMAT = "HTML";
    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

    public static final String ROBOT_LIBRARY_VERSION = loadRobotLibraryVersion();

    private static String loadRobotLibraryVersion() {
        try {
            return ResourceBundle.getBundle(Converter.class.getCanonicalName().replace(".", File.separator))
                    .getString("version");
        } catch (RuntimeException e) {
            return "unknown";
        }
    }

    public Converter(){
        super();
        addKeywordPattern(KEYWORD_PATTERN);
        createKeywordFactory();
    }

    /*protected Dec2Bin dec2bin;
    protected Bin2Dec bin2dec;

    public Dec2Bin getDec2Bin(){return dec2bin;}
    public Bin2Dec getBin2Dec(){return bin2dec;}

    @Override
    public Object runKeyword(String keywordName, Object[] args) {
        return super.runKeyword(keywordName, toStrings(args));
    }

    protected Object[] toStrings(Object[] args) {
        Object[] newArgs = new Object[args.length];
        for (int i = 0; i < newArgs.length; i++) {
            if (args[i].getClass().isArray()) {
                newArgs[i] = args[i];
            } else {
                newArgs[i] = args[i].toString();
            }
        }
        return newArgs;
    }*/

    /*public static Converter getLibraryInstance() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");
        engine.put("library", "Converter");
        engine.eval("from robot.libraries.BuiltIn import BuiltIn");
        engine.eval("instance = BuiltIn().get_library_instance(library)");
        return (Converter) engine.get("instance");
    }*/

    @Override
    public String getKeywordDocumentation(String keywordName) {
        if (keywordName.equals("__intro__"))
            return "This is the general library documentation.";
        return super.getKeywordDocumentation(keywordName);
    }
}
