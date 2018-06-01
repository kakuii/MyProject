package gupaoedu.vip.pattern.observer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EventListenerInvocationHandler implements InvocationHandler {

	private IEventLisenter target;

	public EventListenerInvocationHandler(IEventLisenter target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		method.invoke(target, args);

		return null;
	}

}
