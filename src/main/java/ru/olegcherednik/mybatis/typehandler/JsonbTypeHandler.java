package ru.olegcherednik.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

@SuppressWarnings("unused")
@MappedTypes(Map.class)
@MappedJdbcTypes(JdbcType.OTHER)
public class JsonbTypeHandler extends BaseTypeHandler<Map<String, Object>> {

    private static final String TYPE = "jsonb";
//    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Map<String, Object> map, JdbcType jdbcType) throws SQLException {
//        if (CollectionUtils.isNullOrEmpty(map)) {
//            ps.setNull(i, Types.NULL);
//        } else {
//            try {
//                PGobject obj = new PGobject();
//                obj.setType(TYPE);
//                obj.setValue(mapper.writeValueAsString(map));
//                ps.setObject(i, obj);
//            } catch(JsonProcessingException e) {
//                throw new SQLException(e);
//            }
//        }
    }

    @Override
    public Map<String, Object> getNullableResult(ResultSet rs, String columnName) throws SQLException {
//        return parseJson((PGobject)rs.getObject(columnName));
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Object> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
//        return parseJson((PGobject)rs.getObject(columnIndex));
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Object> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
//        return parseJson((PGobject)cs.getObject(columnIndex));
        return Collections.emptyMap();
    }

//    private Map<String, Object> parseJson(PGobject obj) throws SQLException {
//        if (obj == null) {
//            return Collections.emptyMap();
//        }
//
//        if (TYPE.equalsIgnoreCase(obj.getType())) {
//            try {
//                MappingIterator<Map<String, Object>> it = mapper.readerFor(Map.class).readValues(obj.getValue());
//
//                if (it.hasNextValue()) {
//                    Map<String, Object> res = it.next();
//                    return res.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(res);
//                }
//
//                return Collections.emptyMap();
//            } catch(IOException e) {
//                throw new SQLException(e);
//            }
//        }
//
//        throw new SQLException("Only '" + TYPE + "' is supported");
//    }

}
