import com.neoalvin.tmis.dao.impl.UserInfoDaoImpl;
import com.neoalvin.tmis.model.UserInfo;
import org.junit.Before;
import org.junit.Test;
import com.neoalvin.tmis.dao.UserInfoDao;

import static org.junit.Assert.assertNotNull;

/**
 * 用户信息数据操作实现测试类
 * Created by alvin on 2017/4/23.
 */
public class UserInfoDaoImplTest {

  /**
   * 定义Dao对象
   */
  private static UserInfoDao userInfoDao;

  /**
   * 准备环境，所有用例执行前执行
   */
  @Before
  public void setUp(){
    userInfoDao = new UserInfoDaoImpl();
  }

  /**
   * 测试查询用户
   */
  @Test
  public void testSelectUserInfo(){
    UserInfo userInfo = userInfoDao.selectUserInfoById("130420215");
    System.out.println(userInfo.toString());
    assertNotNull(userInfo);
  }



}
