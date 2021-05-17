package sport;

import java.util.EventObject;

public class Event<T> extends EventObject {

	private T source;
	/**
	 * create an event for the caller
	 * @param source caller
	 */
	public Event(T source) {
		super(source);
		this.source=source;
		
	}
	/**
	 * @return caller instance
	 */
	protected T insTance () {
		return this.source;
	}
}
