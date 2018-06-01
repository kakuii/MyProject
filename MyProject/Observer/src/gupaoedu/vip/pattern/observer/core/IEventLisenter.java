package gupaoedu.vip.pattern.observer.core;

import java.lang.reflect.Method;

public interface IEventLisenter {

	public void addListener(Enum eventType, Object target, Method callback);

	public void trigger(Enum call);

}
