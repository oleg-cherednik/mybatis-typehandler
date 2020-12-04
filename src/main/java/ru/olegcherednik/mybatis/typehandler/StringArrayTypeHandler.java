package ru.olegcherednik.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import software.amazon.awssdk.utils.CollectionUtils;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes({ List.class, Set.class, Collection.class })
public class StringArrayTypeHandler extends BaseTypeHandler<Collection<String>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Collection<String> items, JdbcType jdbcType) throws SQLException {
        if (CollectionUtils.isNullOrEmpty(items)) {
            ps.setNull(i, Types.NULL);
        } else {
            ps.setArray(i, ps.getConnection().createArrayOf(JdbcType.VARCHAR.name(), items.toArray(String[]::new)));
        }
    }

    @Override
    public Collection<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseArray(rs.getArray(columnName));
    }

    @Override
    public Collection<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseArray(rs.getArray(columnIndex));
    }

    @Override
    public Collection<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseArray(cs.getArray(columnIndex));
    }

    private static Collection<String> parseArray(Array arr) throws SQLException {
        if (arr == null) {
            return Collections.emptyList();
        }

        List<String> items = Arrays.stream((String[])arr.getArray()).collect(Collectors.toList());
        return items.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(items);
    }

}
