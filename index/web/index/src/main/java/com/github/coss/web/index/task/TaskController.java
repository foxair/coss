package com.github.coss.web.index.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.coss.app.index.task.ImportShoppingSheetTask;

@Controller
@RequestMapping("/task")
public class TaskController {

    private Logger logger = LoggerFactory.getLogger(TaskController.class);

    @RequestMapping(value = "runTask.do", method = RequestMethod.POST)
    public Model runTask(Model model) {
        ImportShoppingSheetTask task = new ImportShoppingSheetTask();
        try {
            task.executeTask();
            model.addAttribute("msg", "导入完毕");
        } catch (Exception e) {
            model.addAttribute("msg", e.getStackTrace());
            if (logger.isErrorEnabled()) {
                logger.error(e.getMessage(), e);
            }
        }
        return model;
    }
}
