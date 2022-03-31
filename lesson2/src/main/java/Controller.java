import ru.geekbrains.Cart;
import ru.geekbrains.Product;
import ru.geekbrains.ProductRepository;
import ru.geekbrains.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//Массив с продуктами из которого создается репозиторий
        Product[] productRepository = {
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class),
                context.getBean(Product.class)
        };


        ProductRepository productList = context.getBean("pr",ProductRepository.class);
//заполняем репозиторий продуктами (не более пяти)
        ArrayList<Integer> arrId = new ArrayList<>();
        while (productList.size() < 5)
        {
            int id =(int) (Math.random() * productRepository.length);
            if (!arrId.contains(id)) {
                productRepository[id].setId(productList.size() + 1);
                productList.add(productRepository[id]);
                arrId.add(id);
            }
        }
        Cart cart = context.getBean("cart",Cart.class);
        while (true) {
            System.out.println("Set action:");
            Scanner n = new Scanner(System.in);
            String line = n.nextLine();
            while (true) {
                if (line.equals("list")) {
                    System.out.println("List of products:");
                    productList.all();
                    break;
                }
                if (line.contains("get "))
                    for(int j = 0; j < productList.size() + 1; j++)
                        if ( Integer.parseInt(line.split(" ")[1]) == j){
                            productList.get(j).getProduct();
                            break;
                        }
                if (line.contains("cart")){
                    if (line.contains("add"))
                        for(int j = 0; j < productList.size() ; j++)
                            if ( Integer.parseInt(line.split(" ")[2])-1 == j){
                                cart.add(productList.get(j));
                                System.out.println("Put in cart product:" + productList.get(j).getTitle());
                                break;
                            }
                    if (line.equals("cart list")){
                        System.out.println("In your cart:");
                        cart.all();
                        break;
                    }
                }
                break;
            }
            if (line.equals("end")) break;
        }
    }
}
