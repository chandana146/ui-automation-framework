package stl.ui.automation.framework.base.ui.customexception;

public class CustomException extends Exception{

  private boolean suppressStacktrace = false;

  public CustomException(String message, boolean suppressStacktrace) {
    super(message, null, suppressStacktrace, !suppressStacktrace);
    this.suppressStacktrace = suppressStacktrace;
  }

  @Override
  public String toString() {
    if (suppressStacktrace) {
      return getLocalizedMessage();
    } else {
      return super.toString();
    }
  }

}
