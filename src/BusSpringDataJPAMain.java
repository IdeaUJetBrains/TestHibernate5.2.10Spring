
import notentity.Bus;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BusService;

import java.util.Arrays;

public class BusSpringDataJPAMain {
    public static void main(String[] args) {

        //Create Spring application context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/springdata/spring-app-jpa.xml");

        //Get service from context.
        BusService productService = ctx.getBean(BusService.class);

        //Add some items
        productService.add(new Bus(11, "Television"));
        productService.add(new Bus(12, "Phone"));
        productService.addAll(Arrays.asList(
                new Bus(13, "Peach"),
                new Bus(14, "Strawberry"),
                new Bus(15, "Melone"),
                new Bus(16, "Onion")
        ));

        //Test entity listing
        System.out.println("findAll=" + productService.findAll());

        //Test specified find methods
        System.out.println("findByName is 'Peach': " + productService.findByNumberIs("Peach"));
        System.out.println("findByNameContainingIgnoreCase 'on': " + productService.findByNumberContainingIgnoreCase("on"));

        ctx.close();
    }
}
