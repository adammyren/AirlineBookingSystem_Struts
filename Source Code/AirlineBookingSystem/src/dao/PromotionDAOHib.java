package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Flight;
import entities.Promotion;
import entities.PromotionId;

public class PromotionDAOHib extends AbstractDAOHib<Promotion,PromotionId> implements PromotionDAO {

}
