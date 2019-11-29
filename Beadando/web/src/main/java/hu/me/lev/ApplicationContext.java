package hu.me.lev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class ApplicationContext {
    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackages = "hu.me.lev.controller")
    public class ApplicationContext extends WebMvcConfigurerAdapter {
        @Bean
        public BookService bookService() {
            return new BookServiceImpl(bookDAO());
        }

        @Bean(name = "BookDAO")
        public BookDAO bookDAO() {
            return new BookDAOImpl();
        }

        @Bean
        public AuthorService authorService() {
            return new AuthorServiceImpl(authorDAO());
        }

        @Bean(name = "AuthorDAO")
        public AuthorDAO authorDAO() {
            return new AuthorDAOImpl();
        }
    }
}
