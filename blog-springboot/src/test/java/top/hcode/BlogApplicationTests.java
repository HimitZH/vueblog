package top.hcode;

import cn.hutool.core.util.ArrayUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
        int num[] = {1,2};
        List list = Collections.singletonList(num);
        Collections.sort(list);
        System.out.println(list.get(0));
    }

}
