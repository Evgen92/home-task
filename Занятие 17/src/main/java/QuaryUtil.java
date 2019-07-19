import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class QuaryUtil {

    private static final QuaryUtil INSTANCE = new QuaryUtil();

    public void get(DBIndex dbIndex) {
        String query = "SELECT * FROM user";
        try (Connection con = ConnectionUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) {
                System.out.println(rs.getString(String.valueOf(dbIndex)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static QuaryUtil getInstance() {
        return INSTANCE;
    }
}
