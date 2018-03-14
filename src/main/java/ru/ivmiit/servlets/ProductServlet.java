package ru.ivmiit.servlets;

import ru.ivmiit.servlets.entity.Product;
import ru.ivmiit.servlets.service.HibernateConfiguration;
import ru.ivmiit.servlets.service.ProductService;
import ru.ivmiit.servlets.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "productServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private List<Product> products = new ArrayList<Product>();
    private String statusText = "";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        statusText = "";
        request.setAttribute("status", statusText);

        products = productService.getAll();
        request.setAttribute("products", products);

        request.getRequestDispatcher("products.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s1 = request.getParameter("name");
        String s2 = request.getParameter("count");
        String s3 = request.getParameter("price");

        int count = 0;
        double price = 0.0;

        if (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()){
            count = Integer.parseInt(s2);
            price = Double.parseDouble(s3);

            statusText = "";

            Product exist = productService.getByName(s1);
            //если товар уже существует - обновить товар, иначе - создать
            if (exist != null){
                exist.setCount(count);
                exist.setPrice(price);
                productService.updateProduct(exist);
                statusText = "Товар обновлен.";
            }
            else {
                Product product = new Product(s1, count, price);
                statusText = "Товар добавлен.";
                productService.addProduct(product);
            }

        }
        else {
            statusText = "Не все данные введены.";

        }
        products = productService.getAll();
        request.setAttribute("products", products);
        request.setAttribute("status", statusText);
        request.getRequestDispatcher("products.jsp").forward(request, response);


    }

    @Override
    public void destroy() {
        HibernateConfiguration.shutdown();
        super.destroy();
    }
}
