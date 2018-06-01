package gupaoedu.vip.pattern.observer.mouse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import gupaoedu.vip.pattern.observer.core.IEventLisenter;

public class MouseProxyInvocationHandler implements InvocationHandler {

	private IMouse target;
	private IEventLisenter listener;

	public MouseProxyInvocationHandler(IMouse target, IEventLisenter listener) {
		this.target = target;
		this.listener = listener;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		String methodName = method.getName();
		System.out.println(methodName);

		method.invoke(target, args);

		MouseEventType eventEnum = MouseEventType.findMouseEventTypeByValue(methodName);
		listener.trigger(eventEnum);

		return null;
	}

}
