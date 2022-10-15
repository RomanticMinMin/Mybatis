import com.xing.dao.UserMapper;
import com.xing.pojo.User;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
//        UserMapper mapper1 = sqlsession.getMapper(UserMapper.class);
//        mapper1.
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        System.out.println("=================");

        System.out.println(user==user1);

        sqlsession.close();
    }
}
