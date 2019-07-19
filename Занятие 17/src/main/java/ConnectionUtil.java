import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConnectionUtil {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(PropertiesUtil.get("db.url"),
                PropertiesUtil.get("db.user"), PropertiesUtil.get("db.password"));
    }
}
