package com.github.coss.app.index.task;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.github.coss.common.test.BaseDBTestCase;

@ContextConfiguration({ "/META-INF/spring/app-index-test.xml" })
public class ShoppingSheetImportTaskTest extends BaseDBTestCase {

    @Test
    public void testImport() {
        ImportShoppingSheetTask task = new ImportShoppingSheetTask();
        task.executeTask();
    }

}
