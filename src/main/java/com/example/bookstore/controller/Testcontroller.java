package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;



@Controller
public class Testcontroller {
@Autowired
    private BookService bookService;
        
@GetMapping("/")

public String Home()
{
    return "welcome";
}


@GetMapping("/booklist")
public String booklist(Model model )
{
    model.addAttribute("Booklist",bookService.getall() );
    return "booklist";
}



@GetMapping("/bookregister")
public String register(Model model)
{
    Book book=new Book();
    model.addAttribute("bookregister",book);
return "bookregister";
}

@PostMapping("/booklist")
public String clickbtn(@ModelAttribute ("book") Book book )
{
   bookService.addBook(book);
   return "redirect:/booklist";
}

@GetMapping("/updatebook/{id}")
public String updatebook(Model model,@PathVariable int id)
{
    model.addAttribute("bookupdate", bookService.getone(id));
   return "bookupdate" ;
}
@PostMapping("/updatebook/{id}")
public String updatebookonclick(@ModelAttribute ("book") Book book,Model model,@PathVariable int id)
{
  bookService.updateBook(book, id);
  return "redirect:/booklist";
}

@GetMapping("/delete/{id}")
public String dlt(@PathVariable int id,Model model)
{
  bookService.dltBook(id);
  return "redirect:/booklist";
}

@GetMapping("/detail/{id}")
public String detail(@PathVariable int id,Model model)
{
    model.addAttribute("msg", bookService.getone(id));
    return "detail";
}

}
