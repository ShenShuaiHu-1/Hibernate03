import com.ssh.dao.EmpDao;
import com.ssh.dao.EmpDaoimpl;
import com.ssh.entity.Emp;

import java.util.List;

/**
 * @author ShenShuaiHu
 * @create 2019-11-21-11:41
 */
public class TestEmpDao {
    @org.junit.Test
    public void testEmpDaoFindAll() {
        EmpDao e=new EmpDaoimpl();
        List<Emp> list = ((EmpDaoimpl) e).selectQueryAll();
        for (Emp emp : list) {
            System.out.println(emp);

        }
    }
}
