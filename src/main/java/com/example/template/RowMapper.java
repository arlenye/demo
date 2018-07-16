package com.example.template;

import java.sql.ResultSet;

/**
 * Created by James on 2018/7/15.
 */
public interface RowMapper<T> {

    public T mapRow(ResultSet rs, int rowNum) throws Exception;

}
