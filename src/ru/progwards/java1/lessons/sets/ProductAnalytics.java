package ru.progwards.java1.lessons.sets;

import java.util.*;

/*
2.1 Создать класс Product - товар,
2.2 Создать private String code - уникальный артикул товара
2.3 Создать конструктор public Product(String code)
2.4 Метод public String getCode()
*/
class Product {
    private String code; //уникальный артикул товара

    public Product(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}

/*
2.5 Создать класс Shop - магазин
2.6 Создать private List<Product> products - товары имеющиеся в магазине
2.7 Создать конструктор public Shop(List<Product> products)
2.8 Создать метод public List<Product> getProducts()
*/
class Shop {
    private List<Product> products; //товары имеющиеся в магазине

    public Shop(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}


public class ProductAnalytics {
/*
2.10 Создать private List<Shop> shops - список магазинов
2.11 Создать private List<Product> allProducts - список всех товаров
2.12 Создать конструктор  public ProductAnalytics(List<Product> products, List<Shop> shops)
2.13 Создать функцию public Set<Product> existInAll() - товары из products, которые имеются во всех магазинах
2.14 Создать функцию public Set<Product> existAtListInOne() - товары из products, которые имеются хотя бы в одном магазине
2.15 Создать функцию public Set<Product> notExistInShops() - товары из products, которых нет ни в одном магазине
2.16 Создать функцию public Set<Product> existOnlyInOne() - товары из products, которые есть только в одном магазине
*/

    private List<Shop> shops; //список магазинов
    private List<Product> allProducts; //список всех товаров

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops = shops;
        this.allProducts = products;
    }

    //товары из products, которые имеются во всех магазинах
    public Set<Product> existInAll() {
        if (allProducts == null || allProducts.size() == 0) return new HashSet<>();
        if (shops == null || shops.size() == 0) return new HashSet<>();

        //Set<Product> products = new HashSet<Product>(((Shop)it.next()).getProducts()); //надо обязательно перечесть с "товары из products", а так могли бы сэономить
        Set<Product> products = new HashSet<Product>(allProducts);

        Iterator it = shops.iterator();
        while (it.hasNext()) {
            products.retainAll(new HashSet<Product>(((Shop) it.next()).getProducts()));
        }
        return products;
    }

    //товары из products, которые имеются хотя бы в одном магазине
    public Set<Product> existAtLeastInOne() {
        return existAtListInOne();
    }

    public Set<Product> existAtListInOne() {
        if (shops == null || shops.size() == 0) return new HashSet<>();

        Iterator it = shops.iterator();
        //Set<Product> products = new HashSet<Product>(allProducts);
        Set<Product> products = new HashSet<Product>(((Shop) it.next()).getProducts());
        while (it.hasNext()) {
            products.addAll(new HashSet<Product>(((Shop) it.next()).getProducts()));
        }
        products.retainAll(allProducts);
        return products;
    }

    //товары из products, которых нет ни в одном магазине
    public Set<Product> notExistInShops() {
        if (allProducts == null || allProducts.size() == 0) return new HashSet<>();

        Set<Product> products = new HashSet<Product>(allProducts);
        if (shops == null || shops.size() == 0) return products;

        Iterator it = shops.iterator();
        while (it.hasNext()) {
            products.removeAll(new HashSet<Product>(((Shop) it.next()).getProducts()));
        }
        return products;
    }

    //товары из products, которые есть только в одном магазине
    // неоптимально по быстродействию для выполнения постановки
    // всё зависит от вхдных данных, какие будут соотношения: каких данных больше, продуктов или магазинов, allProducts или продуктов в каждом магазине
    public Set<Product> existOnlyInOne() {
        Set<Product> products = new HashSet<Product>();
        if (allProducts == null || allProducts.size() == 0) return products;
        if (shops == null || shops.size() == 0) return products;
        for (int i = 0; i < shops.size(); i++) {
            Set<Product> productsBefore = new HashSet<Product>();
            Set<Product> products1 = new HashSet<Product>();
            Set<Product> productsNow;
            Iterator it = shops.iterator();
            for (int k = 0; k < shops.size(); k++) {
                productsNow = new HashSet<Product>(((Shop) it.next()).getProducts());
                productsNow.retainAll(allProducts);
                if (k < i) {
                    productsBefore.addAll(productsNow);
                } else if (k == i) {
                    products1 = productsNow;
                    products1.removeAll(productsBefore);
                } else {
                    products1.removeAll(productsNow);
                }
            }
            products.addAll(products1);
        }

        return products;
    }

    public static void main(String[] args) {
        Product p1 = new Product("art-1");
        Product p2 = new Product("art-2");
        Product p3 = new Product("art-3");
        Product p4 = new Product("art-4");
        Product p5 = new Product("art-5");
        Product p6 = new Product("art-6");
        Product p7 = new Product("art-7");
        Product p8 = new Product("art-8");
        Product p9 = new Product("art-9");
        Product p10 = new Product("art-10");
        //Магазин 1, товары: art-1,art-9,art-10
        //Магазин 2, товары: art-2,art-3,art-5,art-8
        //В метод передан список товаров: art-1,art-3,art-4,art-8,art-9
        /*Shop s1 = new Shop(new ArrayList<Product>(Arrays.asList(p1, p9, p10)));
        Shop s2 = new Shop(new ArrayList<Product>(Arrays.asList(p2, p3, p5, p8)));
        List<Shop> ss = new ArrayList<Shop>(Arrays.asList(s1, s2));
        List<Product> pa = new ArrayList<Product>(Arrays.asList(p1, p3, p4, p8, p9));
        ProductAnalytics productAnalytics = new ProductAnalytics(pa, ss);
        System.out.println(productAnalytics.existOnlyInOne());*/

        /*Были созданы следующие магазины:
        Магазин 1, товары: art-2,art-7,art-8,art-10
        Магазин 2, товары: art-1,art-4,art-6,art-10
        Магазин 3, товары: art-1,art-4,art-5,art-10
                . В метод передан список товаров: art-5,art-7,art-8,art-10
                .Возвращено множество, содержащее: art-8,art-5,art-7. Ожидалось множество, содержащее: art-8,art-5,art-7,art-10.*/
        Shop s1 = new Shop(new ArrayList<Product>(Arrays.asList(p2, p7, p8, p10)));
        Shop s2 = new Shop(new ArrayList<Product>(Arrays.asList(p1, p4, p6, p10)));
        Shop s3 = new Shop(new ArrayList<Product>(Arrays.asList(p1, p4, p5, p10)));
        List<Shop> ss = new ArrayList<Shop>(Arrays.asList(s1, s2, s3));
        List<Product> pa = new ArrayList<Product>(Arrays.asList(p5, p7, p8, p10));
        ProductAnalytics productAnalytics = new ProductAnalytics(pa, ss);
        System.out.println(productAnalytics.existOnlyInOne());
    }

}
