package frames;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
	ResourceBundle Res;
	Locale locale;
	
	public Language() {
	
	Res = ResourceBundle.getBundle("Subtitles");
	}
}
