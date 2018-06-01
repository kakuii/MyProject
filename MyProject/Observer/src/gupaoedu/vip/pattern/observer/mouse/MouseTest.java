package gupaoedu.vip.pattern.observer.mouse;

import java.lang.reflect.Proxy;

import gupaoedu.vip.pattern.observer.core.Event;
import gupaoedu.vip.pattern.observer.core.EventLisenter;
import gupaoedu.vip.pattern.observer.core.EventListenerInvocationHandler;
import gupaoedu.vip.pattern.observer.core.IEventLisenter;

/**
 * Created by Tom on 2018/3/17.
 */
public class MouseTest {

	public static void main(String[] args) {

		/*
		 * var input = document.getElementById("username");
		 * input.addLisenter("click",function(){
		 *
		 * alert("鼠标点击了这个文本框");
		 *
		 * });
		 *
		 *
		 */

		// 观察者和被观察者之间没有必然联系
		// 注册的时候，才产生联系

		// 解耦

		/*try {
			MouseEventCallback callback = new MouseEventCallback();
			Method onClick = MouseEventCallback.class.getMethod("onClick", Event.class);

			// 人为的调用鼠标的单击事件
			Mouse mouse = new Mouse();
			mouse.addLisenter(MouseEventType.ON_CLICK, callback, onClick);

			mouse.click();

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		MouseEventCallback observer = new MouseEventCallback();
		
		IEventLisenter eventListener = new EventLisenter();
		EventListenerInvocationHandler eh = new EventListenerInvocationHandler(eventListener);
		IEventLisenter elProxy = (IEventLisenter)Proxy.newProxyInstance(eventListener.getClass().getClassLoader(), eventListener.getClass().getInterfaces(), eh);
		System.out.println(elProxy.getClass());
		
		try {
			elProxy.addListener(MouseEventType.ON_CLICK, observer, observer.getClass().getDeclaredMethod("onClick", new Class[] {Event.class}));
			elProxy.addListener(MouseEventType.ON_DOUBLE_CLICK, observer, observer.getClass().getDeclaredMethod("onDoubleClick", new Class[] {Event.class}));
			elProxy.addListener(MouseEventType.ON_DOWN, observer, observer.getClass().getDeclaredMethod("onDown", new Class[] {Event.class}));
			elProxy.addListener(MouseEventType.ON_MOVE, observer, observer.getClass().getDeclaredMethod("onMove", new Class[] {Event.class}));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		IMouse mouse = new Mouse();
		MouseProxyInvocationHandler h = new MouseProxyInvocationHandler(mouse, elProxy);
		IMouse proxy = (IMouse)Proxy.newProxyInstance(mouse.getClass().getClassLoader(), mouse.getClass().getInterfaces(), h);
		System.out.println(proxy.getClass());
		
		proxy.click();
		proxy.doubleClick();
		proxy.down();
		proxy.move();
	}

}
