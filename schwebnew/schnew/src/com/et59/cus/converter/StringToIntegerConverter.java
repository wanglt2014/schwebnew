package com.et59.cus.converter;

import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class StringToIntegerConverter extends DefaultTypeConverter {

	@SuppressWarnings("unchecked")
	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {
		if (toType == Integer.class) { // 当字符串向Date类型转换时
			Integer integer = (Integer) value;
			return integer;
		}
		return null;
	}
}
