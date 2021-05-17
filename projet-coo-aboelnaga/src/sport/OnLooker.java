package sport;

public interface OnLooker <T> extends java.util.EventListener{

	
	public  void middleReact(Event<T> event);
	
	public void startedReact(Event<T> event);
	
	public void endedReact(Event<T> event);
	
	public T getLastCaller();
	
	

}
		