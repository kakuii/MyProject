package gupaoedu.vip.pattern.observer.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 事件的注册和监听 
 * Created by Tom on 2018/3/17.
 */
public class EventLisenter implements IEventLisenter {

	// Map相当于是一个注册器
	private Map<Enum, Event> events = new HashMap<Enum, Event>();

	public void addListener(Enum eventType, Object target, Method callback) {
		// 注册事件
		// 用反射调用这个方法
		events.put(eventType, new Event(target, callback));
	}

	public void trigger(Enum call) {
		if (!this.events.containsKey(call)) {
			return;
		}
		trigger(this.events.get(call).setTrigger(call.toString()));
	}
	
	private void trigger(Event e) {
		e.setSource(this);
		e.setTime(System.currentTimeMillis());

		try {
			e.getCallback().invoke(e.getTarget(), e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
