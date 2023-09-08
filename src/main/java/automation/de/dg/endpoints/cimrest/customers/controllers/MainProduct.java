package automation.de.dg.endpoints.cimrest.customers.controllers;

import automation.de.dg.enumation.Portfolio;
import automation.de.dg.enumation.RouterTypes;
import automation.de.dg.enumation.TariffEighteen;
import automation.de.dg.enumation.TariffTwentythree;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

public class MainProduct {

    public static JSONObject mainProduct() {
        JSONObject requestParams = new JSONObject();
        JSONArray attribute = new JSONArray();
        requestParams.put("attributes", attribute);
        requestParams.put("id", 21002);
        requestParams.put("productInstances", productInstance());

        return requestParams;
    }

    public static JSONArray productInstance() {
        JSONArray instance = new JSONArray();
        JSONObject attribute = new JSONObject();

        JSONArray attr = new JSONArray();

        attribute.put("attributes", attr);
        attribute.put("id", 24001);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 23010);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 23013);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 26024);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("id", 24012);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", customer());
        attribute.put("id", 25004);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 26064);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 26001);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 22002);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 22004);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 26026);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 27001);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 26009);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 23002);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 26028);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 22013);
        instance.put(attribute);

        attribute = new JSONObject();
        attribute.put("attributes", attr);
        attribute.put("id", 25002);
        instance.put(attribute);

        return instance;
    }

    public static JSONArray customer() {
        JSONArray customer = new JSONArray();
        JSONObject attribute = new JSONObject();
        attribute.put("key", "emailAddress");
        attribute.put("value", "ratko.zekic11@seavus.com");
        customer.put(attribute);

        attribute = new JSONObject();
        attribute.put("key", "firstname");
        attribute.put("value", "ratko");
        customer.put(attribute);

        attribute = new JSONObject();
        attribute.put("key", "lastname");
        attribute.put("value", "zekic");
        customer.put(attribute);

        return customer;
    }

    public void defineMainProduct(Portfolio portfolio, int tariff) {
        int mainProduct = 0;
        JSONArray array = new JSONArray();
        switch (portfolio) {
            case Eighteen -> {
                if (TariffEighteen.ThreeHundred.option == 300) {
                    mainProduct = 10290;
                    array.put(10539);
                    array.put(10002);
                    array.put(10063);
                    array.put(10313);
                    array.put(10295);
                    array.put(10524);
                    break;
                } else if (TariffEighteen.FourHundred.option == 400) {
                    mainProduct = 10291;
                    array.put(10002);
                    array.put(10308);
                    array.put(10343);
                    array.put(10296);
                    array.put(10313);
                    array.put(10315);
                    array.put(10063);
                    array.put(10525);
                    array.put(10330);
                    break;
                } else if (TariffEighteen.SixHundred.option == 600) {
                    mainProduct = 10292;
                    array.put(10002);
                    array.put(10309);
                    array.put(10313);
                    array.put(10343);
                    array.put(10297);
                    array.put(10063);
                    array.put(10525);
                    break;
                } else if (TariffEighteen.EightHundred.option == 800) {
                    mainProduct = 10538;
                    array.put(10002);
                    array.put(10313);
                    array.put(10298);
                    array.put(10343);
                    array.put(10063);
                    break;
                } else if (TariffEighteen.Thousand.option == 1000) {
                    mainProduct = 10293;
                    array.put(10002);
                    array.put(10063);
                    array.put(10298);
                    array.put(10313);
                    array.put(10343);
                    array.put(10542);
                    break;
                } else {
                    Assert.fail("Invalid tariff " + tariff + " is sent for Portfolio " + portfolio);
                }
            }
            case Twentythree -> {
                if (TariffTwentythree.Hundred.option == 100) {
                    mainProduct = 21001;
                    array.put(26001);
                    array.put(22002);
                    array.put(22004);
                    array.put(26013);
                    break;
                } else if (TariffTwentythree.ThreeHundred.option == 300) {
                    mainProduct = 21002;
                    array.put(26001);
                    array.put(22002);
                    array.put(22004);
                    array.put(27001);
                    array.put(26014);
                    break;
                } else if (TariffTwentythree.FourHundred.option == 400) {
                    mainProduct = 21008;
                    break;
                } else if (TariffTwentythree.FiveHundred.option == 500) {
                    mainProduct = 21003;
                    array.put(26001);
                    array.put(22002);
                    array.put(22004);
                    array.put(27001);
                    array.put(26015);
                    break;
                } else if (TariffTwentythree.Thousand.option == 1000) {
                    mainProduct = 21004;
                    array.put(26001);
                    array.put(22002);
                    array.put(22004);
                    array.put(27001);
                    array.put(26016);
                    break;
                } else {
                    Assert.fail("Invalid tariff " + tariff + " is sent for Portfolio " + portfolio);
                }
            }
            default -> {
                mainProduct = 0;
                break;
            }
        }
        setMainProduct(mainProduct, array);
    }

    public void setRouter(Portfolio portfolio, RouterTypes routerType) {
        JSONArray list = getProductList();
        if (routerType.equals(RouterTypes.Bundle)) {
            if (portfolio.equals(Portfolio.Twentythree)) {
                list.put(24004);
                list.put(24008);
                list.put(24008);
                list.put(23009);
                list.put(26023);
            } else {
                list.put(10680);
                list.put(10683);
                list.put(10728);
                list.put(10686);
            }
        }
    }

    static int mainProduct;
    static JSONArray productList;

    public void setMainProduct(int prod, JSONArray list) {
        mainProduct = prod;
        productList = list;
    }

    public int getMainProduct() {
        return mainProduct;
    }

    public JSONArray getProductList() {
        return productList;
    }
}
