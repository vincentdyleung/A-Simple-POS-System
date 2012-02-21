package info.vforvincent.comp3021.pos.storage;

import info.vforvincent.comp3021.pos.entities.Entity;

import java.util.HashMap;

public abstract class Storage {
	
	protected HashMap<String, Entity> mEntities;
	
	public Storage () {
		mEntities = new HashMap<String, Entity>();
	}
	
	public boolean contains(String key) {
		return false;
	}
	
	public void add(Entity value) {
		
	}
	
	public Entity get(String key) {
		return null;
	}
}
