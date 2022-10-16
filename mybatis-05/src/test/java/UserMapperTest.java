import com.xing.dao.UserMapper;
import com.xing.pojo.User;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class UserMapperTest {


    @Test
    public void test(){

        SqlSession sqlsession = MybatisUtils.getSqlsession();

        //底层使用反射
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        sqlsession.close();
    }

}
