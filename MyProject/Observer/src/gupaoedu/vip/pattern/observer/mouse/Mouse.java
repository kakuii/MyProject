package gupaoedu.vip.pattern.observer.mouse;

/**
 * 被观察者 如果做过Swing开发的话，有一种似曾相识的感觉
 *  Created by Tom on 2018/3/17.
 */
public class Mouse implements IMouse {

	public void click() {
		System.out.println("鼠标单击");
	}

	public void doubleClick() {
		System.out.println("鼠标双击");
	}

	public void up() {
		System.out.println("鼠标弹起");
	}

	public void down() {
		System.out.println("鼠标按下");
	}

	public void wheel() {
		System.out.println("鼠标滚动");
	}

	public void move() {
		System.out.println("鼠标移动");
	}

	public void over() {
		System.out.println("鼠标悬停");
	}

	/*// Map相当于是一个注册器
	private Map<Enum, Event> events = new HashMap<Enum, Event>();

	public Map<Enum, Event> getEvents() {
		return events;
	}

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
	}*/

}
