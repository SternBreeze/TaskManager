package app.task.service;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
	IN_PROGRESS,
	COMPLETED,
	CANCELLED;

	@JsonValue
	@Override
	public String toString() {
		switch (this) {
			case IN_PROGRESS:
				return "in progress";
			case COMPLETED:
				return "completed";
			case CANCELLED:
				return "cancelled";
			default:
				throw new IllegalArgumentException();
		}
	}
}
