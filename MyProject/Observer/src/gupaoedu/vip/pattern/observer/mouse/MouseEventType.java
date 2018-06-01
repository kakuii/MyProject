package gupaoedu.vip.pattern.observer.mouse;

/**
 * Created by Tom on 2018/3/17.
 */
public enum MouseEventType {
    ON_CLICK("click"),
    ON_DOUBLE_CLICK("doubleClick"),
    ON_UP("up"),
    ON_DOWN("down"),
    ON_WHEEL("wheel"),
    ON_MOVE("move"),
    ON_OVER("over");
	
	private String value;
	
	private MouseEventType(String value) {
		
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static MouseEventType findMouseEventTypeByValue(String value) {
		MouseEventType[] mouseEventTypes = MouseEventType.values();
		for(MouseEventType enumType : mouseEventTypes) {
			if(enumType.value.equals(value)) {
				return enumType;
			}
		}
		
		return null;
	}

}
