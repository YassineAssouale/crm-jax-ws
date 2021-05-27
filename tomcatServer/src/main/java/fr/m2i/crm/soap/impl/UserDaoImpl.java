package fr.m2i.crm.soap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.m2i.crm.soap.config.LocalEntityManagerFactory;
import fr.m2i.crm.soap.dao.UserDao;
import fr.m2i.crm.soap.exception.DaoException;
import fr.m2i.crm.soap.model.User;

public class UserDaoImpl implements UserDao {
	
	private EntityManager em;
	
	public UserDaoImpl() {
		this.em = LocalEntityManagerFactory.createEntityManager();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getById(Integer id) throws DaoException {
		try {
            return em.find(User.class, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getByUsername(String username) throws DaoException {
		try {
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = ?1",
					User.class);
			query.setParameter(1, username);
			return query.getSingleResult();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getByUsernameAndPassword(String username, String password) throws DaoException {
		try {
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAll() throws DaoException {
		try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.id", User.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createUser(User user) throws DaoException {
		try {
            em.persist(user);
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUser(User user) throws DaoException {
		try {
            em.merge(user);
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUser(User user) throws DaoException {
		try {
            em.remove(em.merge(user));
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
