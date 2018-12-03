import entity.Entitybus;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.EntitybusService;

import java.util.Arrays;

public class SpringDataJPAMain {
    public static void main(String[] args) {

        //Create Spring application context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/springdata/spring-app-jpa.xml");

        //Get service from context.
        EntitybusService productService = ctx.getBean(EntitybusService.class);

        //Add some items
        productService.add(new Entitybus(11, "Television"));
        productService.add(new Entitybus(12, "Phone"));
        productService.addAll(Arrays.asList(
                new Entitybus(13, "Peach"),
                new Entitybus(14, "Strawberry"),
                new Entitybus(15, "Melone"),
                new Entitybus(16, "Onion")
        ));

        //Test entity listing
        System.out.println("findAll=" + productService.findAll());

        //Test specified find methods
        System.out.println("findByName is 'Peach': " + productService.findByEnumberIs("Peach"));
        System.out.println("findByNameContainingIgnoreCase 'on': " + productService.findByEnumberContainingIgnoreCase("on"));

        ctx.close();
    }
}
