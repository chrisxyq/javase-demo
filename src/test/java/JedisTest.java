import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author chrisxu
 * @create 2021-10-17 21:36
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
public class JedisTest {
    /**
     * 待补充api测试代码
     * 需要启动E:\mysoftware\redis-2.4.5-win32-win64\64bit\redis-server.exe
     */
    @Test
    public void test() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());
    }

    /**
     * 事务测试
     */
    @Test
    public void test2() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "kuangshen");
        Transaction multi = jedis.multi();
        String s = jsonObject.toJSONString();
//        jedis.watch(s);
        try {
            multi.set("user1", s);
            multi.set("user2", s);
            int i = 1 / 0;
            multi.exec();
        } catch (Exception e) {
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }
}
