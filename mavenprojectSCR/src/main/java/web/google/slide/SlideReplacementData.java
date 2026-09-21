package web.google.slide;

import java.awt.Color;

public class SlideReplacementData {
  public String googleSlideVariableName;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
  private String googleSlideVariableValue;
  private Color color;
public SlideReplacementData(String googleSlideVariableName, String googleSlideVariableValue) {
	super();
	this.googleSlideVariableName = googleSlideVariableName;
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
