package com.fengwenyi.applib;

import android.app.Activity;

import com.fengwenyi.applib.util.AppManager;
import com.fengwenyi.applib.util.FileUtil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        //FileUtil.INSTANCE.write("E:\\Temp\\file/test.txt", "test", false);
    }
}