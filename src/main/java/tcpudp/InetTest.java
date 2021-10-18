package tcpudp;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author chrisxu
 * @create 2021-10-17 15:47
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
public class InetTest {
    @Test
    public void test() throws UnknownHostException {
        InetAddress address1 = InetAddress.getByName("www.baidu.com");
//        InetAddress address2 = InetAddress.getByName("https://chrisxyq.github.io/");
        InetAddress address3 = InetAddress.getByName("localhost");
        System.out.println(address1);
//        System.out.println(address2);
        System.out.println(address3);

    }
}
