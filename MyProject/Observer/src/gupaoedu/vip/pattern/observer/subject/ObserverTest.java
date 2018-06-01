package gupaoedu.vip.pattern.observer.subject;

import gupaoedu.vip.pattern.observer.core.Event;

import java.lang.reflect.Method;

/**
 * Created by Tom on 2018/3/17.
 */
public class ObserverTest {

	public static void main(String[] args) {

		try {

			// 观察者
			Observer observer = new Observer();
			Method advice = Observer.class.getMethod("advice", new Class<?>[] { Event.class });

			// 这里写Lily
			Subject subject = new Subject();
			subject.addListener(SubjectEventType.ON_ADD, observer, advice);
			subject.addListener(SubjectEventType.ON_EDIT, observer, advice);
			subject.addListener(SubjectEventType.ON_RMOVE, observer, advice);
			subject.addListener(SubjectEventType.ON_QUERY, observer, advice);

			subject.add();
			subject.remove();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
