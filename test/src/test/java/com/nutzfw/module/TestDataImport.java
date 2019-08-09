package com.nutzfw.module;

import com.nutzfw.modules.sys.entity.DataTable;
import com.nutzfw.modules.sys.service.DataTableService;
import com.nutzfw.modules.tabledata.service.DataImportHistoryService;
import com.nutzfw.modules.tabledata.thread.CheckDataThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Record;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * @author 黄川 huchuc@vip.qq.com
 * @date: 2018/5/14
 * 描述此类：
 */
@RunWith(TestRunner.class)
@IocBean
public class TestDataImport {

    @Inject
    DataImportHistoryService importHistoryService;

    @Inject("dataTableService")
    DataTableService dataTableService;

    @Inject("refer:$ioc")
    Ioc ioc;

    @Inject
    Dao dao;

    /**
     * 效验导入数据
     */
    @Test
    public void testChecData() {
        CheckDataThread checkDataThread = new CheckDataThread(ioc, importHistoryService.fetch("2"));
        checkDataThread.run();
    }

    /**
     * 更新记录
     */
    @Test
    public void updateByID() {
        Record map = new Record();
        map.put(".table", "user_info");
        map.put("*name", "张三");
        map.put("*age", "aaa");
        map.put("menu_name", "测试值");
        int updateCount = dao.update(map);
        System.out.println(updateCount);
    }

    /**
     * 更新记录
     */
    @Test
    public void fetchAllFields() {
        DataTable dataTable = dataTableService.fetchAllFields(2);
        System.out.println(dataTable);
    }


}
