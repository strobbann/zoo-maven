package se.rosa.user.dao;

import se.rosa.user.domain.User;

import java.util.*;

/**
 * Created by Robert on 2019-06-14.
 */
public class UserDaoImpl implements UserDao {

	private Map<Long, User> users;

	public UserDaoImpl() {
		users = new HashMap<>();
	}

	@Override
	public void create(User user) {
		Optional.of(user).ifPresent(u -> users.put(u.getId(), u));
	}

	@Override
	public User read(Long id) {
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
