package com.calculate.gst.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GstType {
	ADDGST("ADDGST"), REMOVEGST("REMOVEGST");

	private String value;

	GstType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static GstType fromValue(String text) {
		for (GstType b : GstType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

}
