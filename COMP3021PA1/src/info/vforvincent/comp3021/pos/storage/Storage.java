package info.vforvincent.comp3021.pos.storage;

import info.vforvincent.comp3021.pos.entities.Entity;

import java.util.HashMap;

public abstract class Storage {
	
	protected HashMap<String, Entity> mEntities;
	
	public Storage () {
		mEntities = new HashMap<String, Entity>();
	}
	
	public abstract boolean contains(String key);
	
	public abstract void add(Entity value);
	
	public abstract Entity get(String key);
}
