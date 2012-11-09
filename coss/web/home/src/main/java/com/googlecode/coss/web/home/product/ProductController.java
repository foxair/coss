package com.googlecode.coss.web.home.product;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.binq.biz.pdm.po.Product;
import com.binq.biz.pdm.service.ProductService;
import com.googlecode.coss.common.core.orm.mybatis.Page;

@Controller
@RequestMapping("/product")
public class ProductController {

    private Logger         logger = LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductService productService;

    @RequestMapping("index.htm")
    public ModelMap queryPage(@RequestParam(value = "page", required = false) Integer pageNum) {
        Page<Product> page = productService.queryPage(pageNum, 5, null);
        ModelMap m = new ModelMap();
        m.addAttribute("page", page);
        m.addAttribute("pageNumbers", page.getPageNumbers());
        logger.info("一个logger输出:" + m);
        return m;
    }

    @RequestMapping(value = "addProduct.do", method = RequestMethod.POST)
    public String addProduct(Product product, Model model, Errors errors) {
        product.setGmtCreate(new Date());
        productService.save(product);
        model.addAttribute("msg", "处理成功");
        return "product/result";
    }
}
