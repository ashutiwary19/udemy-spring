package com.ashu.springbootdemo.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.ashu.springbootdemo.model.Holiday;

public class HolidayRowMapper implements RowMapper<Holiday> {

	@Override
	@Nullable
	public Holiday mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
		Holiday holiday = new Holiday();
		holiday.setDay(rs.getString("day"));
		holiday.setReason(rs.getString("reason"));
		holiday.setType(Holiday.Type.FEDERAL.toString().equalsIgnoreCase(rs.getString("type")) ? Holiday.Type.FEDERAL
				: Holiday.Type.FESTIVAL);
		holiday.setCreatedBy(rs.getString("created_by"));
		holiday.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
		return holiday;
	}

}
