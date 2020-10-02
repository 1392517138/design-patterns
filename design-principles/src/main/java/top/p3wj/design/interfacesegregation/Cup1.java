package top.p3wj.design.interfacesegregation;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 12:21 下午
 */
public class Cup1 implements IDrink{
    public String drinkCurb() {
        return null;
    }

    public String drinkWater() {
        return "This is an ordinary day,I just want water!";
    }
}
