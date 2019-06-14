package se.rosa.user.domain;

import java.util.Objects;

/**
 * Created by Robert on 2019-06-14.
 */
public class User {
	private Long id;

	private User(Builder builder) {
		this.id = Objects.requireNonNull(builder.id);
	}

	public Long getId() {
		return id;
	}

	public static class Builder {
		private Long id;

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
