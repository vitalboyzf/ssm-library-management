package com.vital.controller;

import com.github.pagehelper.PageInfo;
import com.vital.po.BookInfo;
import com.vital.service.BookInfoService;
import com.vital.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookInfoService bookInfoService;

    /**
     * 图书首页
     */
    @GetMapping("/bookIndex")
    public String bookIndex() {
        return "book/bookIndex";
    }

    /**
     * 添加页面
     */
    @GetMapping("/addBook")
    public String addBook() {
        return "book/addBook";
    }

    /**
     * 实现添加功能
     */
    @ResponseBody
    @PostMapping("/addBookSubmit")
    public R addBookSubmit(@RequestBody BookInfo bookInfo) {
        int t = bookInfoService.addBookSubmit(bookInfo);
        if (t > 0) {
            return R.ok("添加成功");
        } else {
            return R.fail("添加失败");
        }
    }

    /**
     * 获取图书信息
     */
    @ResponseBody
    @GetMapping("/bookAll")
    public R bookAll(BookInfo info, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<BookInfo> pageInfo = bookInfoService.queryBookInfoAll(info, page, limit);
        return R.ok("成功", pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 删除功能
     */
    @ResponseBody
    @PostMapping("/deleteBookByIds")
    public R deleteBookByIds(String ids) {
        int t = bookInfoService.deleteBookInfoById(Arrays.asList(ids.split(",")));
        if (t > 0) {
            return R.ok();

        } else {
            return R.fail("删除失败");
        }
    }

    /**
     * 根据id查询记录信息
     */
    @GetMapping("/queryBookInfoById")
    public String queryBookInfoById(Model model, Integer id) {
        //根据id获取对象
        BookInfo info = bookInfoService.queryBookInfoById(id);
        model.addAttribute("info", info);
        return "book/updateBook";
    }

    /**
     * 根据id返回记录信息
     */
    @ResponseBody
    @GetMapping("/getBookInfoById")
    public R getBookInfoById(Integer id) {
        //根据id获取对象
        BookInfo info = bookInfoService.queryBookInfoById(id);
        return R.ok("查询成功", info);
    }

    /**
     * 修改实现功能
     */
    @ResponseBody
    @PostMapping("/updateBookInfoSubmit")
    public R updateBookInfoSubmit(@RequestBody BookInfo info) {
        int i = bookInfoService.updateBookSubmit(info);
        if (i > 0) {
            return R.ok();
        } else {
            return R.fail("修改失败");
        }
    }
}
