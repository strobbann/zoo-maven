package se.rosa.user.dao;

import se.rosa.logging.Logger;
import se.rosa.user.domain.User;

import java.util.*;

/**
 * Created by Robert on 2019-06-14.
 */
public class UserDaoImpl implements UserDao {

	private Map<Long, User> users;
	private Logger logger;

	public UserDaoImpl() {
		users = new HashMap<>();
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void log(String message) {
		if (logger != null) {
			logger.log(message, this);
		}
	}

	@Override
	public void create(User user) {
		log("on create user");
		Optional.of(user).ifPresent(u -> users.put(u.getId(), u));
	}

	@Override
	public User read(Long id) {
		log("on read user");
		return Optional.of(users.get(id)).orElseThrow(() -> new IllegalArgumentException("User does not exist"));
	}

	@Override
	public User delete(Long id) {
		return null;
	}

	@Override
	public User update(User user) {
		return null;
	}
}
