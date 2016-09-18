package entities;

//Abstract class to define methods needed to implement AbstractDAO
public abstract class AbstractEntity<Key> {
	
	public abstract Key getKey();
	public abstract void setKey(Key key);



}
