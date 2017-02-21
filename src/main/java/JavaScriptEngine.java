
import java.io.InputStreamReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public final class JavaScriptEngine {

	private static Invocable jsEngine;

	static {

		final ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		final ScriptEngine baseEngine = scriptEngineManager.getEngineByName("nashorn");
		try {
			baseEngine.eval(
					new InputStreamReader(JavaScriptEngine.class.getClassLoader().getResourceAsStream("main.js")));
			JavaScriptEngine.jsEngine = (Invocable) baseEngine;
		} catch (ScriptException e) {
			System.err.println("Cannot initialize javascript engine");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static final <T extends Object> T call(final String functionName, Object... parameters) throws NoSuchMethodException, ScriptException {
		return (T) jsEngine.invokeFunction(functionName, parameters);
	}
}
