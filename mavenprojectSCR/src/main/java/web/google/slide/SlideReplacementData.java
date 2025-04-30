package web.google.slide;

public class SlideReplacementData {
  public String googleSlideVariableName;
  private String googleSlideVariableValue;
public SlideReplacementData(String googleSlideVariableName, String googleSlideVariableValue) {
	super();
	this.googleSlideVariableName = "{{" + googleSlideVariableName + "}}";
	this.googleSlideVariableValue = googleSlideVariableValue;
}
public String getGoogleSlideVariableName() {
	return googleSlideVariableName;
}
public void setGoogleSlideVariableName(String googleSlideVariableName) {
	this.googleSlideVariableName = googleSlideVariableName;
}
public String getGoogleSlideVariableValue() {
	return googleSlideVariableValue;
}
public void setGoogleSlideVariableValue(String googleSlideVariableValue) {
	this.googleSlideVariableValue = googleSlideVariableValue;
}
}
