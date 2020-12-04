package ru.olegcherednik.mybatis.typehandler;

/**
 * A generic type handler for all JSON/JSONb fields. To use it, extend it and specify a type to map
 *
 * @param <T>
 */
public abstract class AbstractJsonTypeHandler<T> {/*extends BaseTypeHandler<T> {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    protected abstract TypeReference<T> getTypeReference();

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T object, JdbcType jdbcType)
            throws SQLException {
        String json;
        if (object == null) {
            json = "[]";
        } else {
            try {
                json = objectMapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                throw new SQLException(e);
            }
        }

        preparedStatement.setString(i, json);
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String json = resultSet.getString(s);
        if (!resultSet.wasNull()) {
            return parseJson(json);
        }

        return null;
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String json = resultSet.getString(i);
        if (!resultSet.wasNull()) {
            return parseJson(json);
        }

        return null;
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String json = callableStatement.getString(i);
        if (!callableStatement.wasNull()) {
            return parseJson(json);
        }

        return null;
    }

    private T parseJson(String json) throws SQLException {
        try {
            if (json.startsWith("\"")) {
                json = StringEscapeUtils.unescapeJava(json);
                json = json.substring(1, json.length() - 1);
            }
            return objectMapper.readValue(json, getTypeReference());
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }                                              */
}
