package edu.cau;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;

/**
 * 代码中的枚举转与数据库中存储的数字标识进行转化
 */
public class LevelTypeHandler extends BaseTypeHandler<Level> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Level parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getVal());
    }

    @Override
    public Level getNullableResult(ResultSet rs, String columnName) throws SQLException {

        int val = rs.getInt(columnName);
        Level level = Stream.of(Level.values()).filter(item -> item.getVal() == val).findFirst().orElse(Level.LOW);
        return level;
    }

    @Override
    public Level getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int val = rs.getInt(columnIndex);
        Level level = Stream.of(Level.values()).filter(item -> item.getVal() == val).findFirst().orElse(Level.LOW);
        return level;
    }

    @Override
    public Level getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int val = cs.getInt(columnIndex);
        Level level = Stream.of(Level.values()).filter(item -> item.getVal() == val).findFirst().orElse(Level.LOW);
        return level;
    }
}
