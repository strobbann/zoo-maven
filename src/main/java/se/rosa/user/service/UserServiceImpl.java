package se.rosa.user.service;

import se.rosa.user.dao.UserDao;
import se.rosa.user.dao.UserDaoImpl;

import java.util.TreeMap;

/**
 * Created by Robert on 2019-06-14.
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	private UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean login(Long id) {
		return userDao.read(id) != null;
	}
}
