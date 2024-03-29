package ecpay.invoice.integration.verification;

import ecpay.invoice.integration.domain.IssueObj;
import ecpay.invoice.integration.ecpayOperator.InvoiceVerifyBase;
import ecpay.invoice.integration.errorMsg.ErrorMessage;
import ecpay.invoice.integration.exception.EcpayException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.lang.reflect.Method;

public class VerifyIssue extends InvoiceVerifyBase
{
    public VerifyIssue()
    {
        super();
    }

    public String getAPIUrl(String mode)
    {
        Element ele = (Element) doc.getElementsByTagName("InvoiceIssue").item(0);
        String url = "";
        NodeList nodeList = ele.getElementsByTagName("url");
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            ele = (Element) nodeList.item(i);
            if (ele.getAttribute("type").equalsIgnoreCase(mode))
            {
                url = ele.getTextContent();
                break;
            }
        }
        if (url.isEmpty())
            throw new EcpayException(ErrorMessage.OperatingMode_ERROR);
        return url;
    }

    public void verifyParams(IssueObj obj)
    {
        Class<?> cls = obj.getClass();
        Method method;
        String objValue;
        Element ele = (Element) doc.getElementsByTagName("InvoiceIssue").item(0);
        NodeList nodeList = ele.getElementsByTagName("param");
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Element tmpEle = (Element) nodeList.item(i);

            try
            {
                method = cls.getMethod("get" + tmpEle.getAttribute("name").substring(0, 1).toUpperCase() + tmpEle.getAttribute("name").substring(1), null);
                objValue = method.invoke(obj, null).toString();
            }
            catch (Exception e)
            {
                throw new EcpayException(ErrorMessage.OBJ_MISSING_FIELD + ": " + tmpEle.getAttribute("name"));
            }
//			requireCheck(tmpEle.getAttribute("name"), objValue, tmpEle.getAttribute("require").toString());
            valueCheck(tmpEle.getAttribute("type"), objValue, tmpEle);
            verifyIssue(obj);
        }
    }
}
