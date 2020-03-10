package servlets;

import dao.TestDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/test")
public class testServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //初始化Spring容器ApplicationContext，加载配置文件
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取test实例
        TestDao tt = (TestDao)appCon.getBean("test");
        tt.sayHello();
        response.getWriter().println("Test has been done");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
       doGet(request,response);
    }
}
