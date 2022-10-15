import com.xing.dao.StudentMapper;
import com.xing.dao.TeacherMapper;
import com.xing.pojo.Student;
import com.xing.pojo.Teacher;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {

        SqlSession sqlsession = MybatisUtils.getSqlsession();
        TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlsession.close();
    }

    @Test
    public void testStudent(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        StudentMapper mapper = sqlsession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
            sqlsession.close();
        }
    }
    @Test
    public void testStudent2(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        StudentMapper mapper = sqlsession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
            sqlsession.close();
        }
    }
}
