package info.vforvincent.comp3021.pos.storage;

import java.util.HashMap;

public interface Storage {
	
	public boolean contains(Object key);
	
	public void add(Object value);
	
	public Object get(Object key);
}
