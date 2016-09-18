package dao;

import java.util.List;

import entities.Promotion;

public interface PromotionDAO {
	
	public List<Promotion> getAll(Class<Promotion> theClass); 	
}
